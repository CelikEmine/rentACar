package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.*;
import com.etiya.rentACar.business.adapters.PaymentBankAdapterService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.CreateRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.ListRentalAdditionalServiceDetailDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.PaymentDao;
import com.etiya.rentACar.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentManager implements PaymentService {

    private PaymentDao paymentDao;
    private ModelMapperService modelMapperService;
    private CustomerService customerService;
    private RentalService rentalService;
    private CityService cityService;
    private CarService carService;
    private InvoiceService invoiceService;
    private RentalAdditionalServiceDetailService rentalAdditionalServiceDetailService;
    private AdditionalServiceService additionalServiceService;
    private PaymentBankAdapterService paymentBankAdapterService;

    public PaymentManager(PaymentDao paymentDao, ModelMapperService modelMapperService,
                          CustomerService customerService, RentalService rentalService,
                          CityService cityService, CarService carService, InvoiceService invoiceService,
                          RentalAdditionalServiceDetailService rentalAdditionalServiceDetailService ,
                          AdditionalServiceService additionalServiceService,PaymentBankAdapterService paymentBankAdapterService) {
        this.paymentDao = paymentDao;
        this.modelMapperService = modelMapperService;
        this.customerService = customerService;
        this.rentalService = rentalService;
        this.cityService = cityService;
        this.carService = carService;
        this.invoiceService = invoiceService;
        this.rentalAdditionalServiceDetailService = rentalAdditionalServiceDetailService;
        this.additionalServiceService = additionalServiceService;
        this.paymentBankAdapterService=paymentBankAdapterService;
    }

    @Override
    public Result add(CreatePaymentRequest createPaymentRequest) {

        this.makePayment(createPaymentRequest);
        Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest, Payment.class);

        Rental rental=this.rentalService.add(createPaymentRequest.getCreateRentalRequest()).getData();
        createPaymentRequest.getCreateInvoiceRequest().setRentalId(rental.getId());

        createPaymentRequest.getCreateInvoiceRequest().setDayCount(this.diffDates(createPaymentRequest));
        createPaymentRequest.getCreateInvoiceRequest().setTotalPrice(this.addTotalPrice(createPaymentRequest));

        Invoice invoice=this.invoiceService.add(createPaymentRequest.getCreateInvoiceRequest()).getData();


        this.newOrderedAdditionalProperty(createPaymentRequest,rental);


        payment.setRental(rental);
        payment.setInvoice(invoice);
        payment.setTotalPrice(addTotalPrice(createPaymentRequest));

        this.paymentDao.save(payment);

        return new SuccessResult(BusinessMessages.PaymentMessage.PAYMENT_ADDED);
    }

    @Override
    public DataResult<List<ListPaymentDto>> getALl() {

        List<Payment> payments = this.paymentDao.findAll();
        List<ListPaymentDto> response = payments.stream()
                .map(payment -> this.modelMapperService.forDto().map(payment, ListPaymentDto.class))
                .collect(Collectors.toList());
        return new SuccessDataResult<List<ListPaymentDto>>(response);

    }


    public double addTotalPrice(CreatePaymentRequest createPaymentRequest) {

        DataResult<RentalDto> rentalDto = this.rentalService.getById(createPaymentRequest.getCreateRentalRequest().getCarId());
        int dayDiff = diffDates(createPaymentRequest);
        double carTotalPrice = dayDiff * rentalDto.getData().getDailyPrice();
        double additionalPropertyTotalPrice = dayDiff * additionalPropertyTotal(createPaymentRequest);
        double cityDiff = checkCity(createPaymentRequest);
        return (carTotalPrice + cityDiff + additionalPropertyTotalPrice);

    }


    public int diffDates(CreatePaymentRequest createPaymentRequest) {
        long period = ChronoUnit.DAYS.between(createPaymentRequest.getCreateRentalRequest().getRentDate(), createPaymentRequest.getCreateRentalRequest().getReturnDate());
        return (int) period;
    }

    public double checkCity(CreatePaymentRequest createPaymentRequest) {

        if (createPaymentRequest.getCreateRentalRequest().getRentCityId() != createPaymentRequest.getCreateRentalRequest().getReturnCityId()) {

            return 750;
        }
        return 0;
    }


    public void makePayment(CreatePaymentRequest createPaymentRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(createPaymentRequest.getCardNumber());
        creditCard.setCardFirstName(createPaymentRequest.getCardFirstName());
        creditCard.setCardLastName(createPaymentRequest.getCardLastName());
        creditCard.setCvc(createPaymentRequest.getCvc());
        creditCard.setExpirationDate(createPaymentRequest.getCardExpirationDate());
        if (this.paymentBankAdapterService.pay(creditCard)) {
        } else {
            throw new BusinessException(BusinessMessages.PaymentMessage.PAYMENT_NOT_ACCEPTED);
        }
    }


    public double additionalPropertyTotal(CreatePaymentRequest createPaymentRequest) {
        double totalPrice = 0;
        for (int orderedAdditionalItem : createPaymentRequest.getOrderedAdditionalPropertyIdentities()) {

            List<ListRentalAdditionalServiceDetailDto> result2 = this.rentalAdditionalServiceDetailService.getByAdditionalserviceId(orderedAdditionalItem).getData();

            AdditionalServiceDto response = this.additionalServiceService.getById(orderedAdditionalItem).getData();
            totalPrice += response.getDailyPrice();
        }
        return totalPrice;
    }

    public void newOrderedAdditionalProperty(CreatePaymentRequest createPaymentRequest, Rental rental){

        CreateRentalAdditionalServiceDetailRequest createRentalAdditionalServiceDetailRequest = new CreateRentalAdditionalServiceDetailRequest();

        for (int orderedAdditionalItem : createPaymentRequest.getOrderedAdditionalPropertyIdentities()) {
            createRentalAdditionalServiceDetailRequest.setRentalId(rental.getId());
            createRentalAdditionalServiceDetailRequest.setAdditionalServiceId(orderedAdditionalItem);
            rentalAdditionalServiceDetailService.add(createRentalAdditionalServiceDetailRequest);
        }

        // List<ListRentalAdditionalServiceDetailDto> response=this.rentalAdditionalServiceDetailService.getByRentalId(rental.getId()).getData();
        //List<RentalAdditionalServiceDetail> results=response.stream().map(result->this.modelMapperService.forDto().map(result,RentalAdditionalServiceDetail.class)).collect(Collectors.toList());

        /*for(RentalAdditionalServiceDetail item : results){
            payment.setRentalAdditionalServiceDetail(item);
        }*/


    }

}
