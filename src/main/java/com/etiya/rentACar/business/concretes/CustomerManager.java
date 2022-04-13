package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.CustomerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CustomerDao;
import com.etiya.rentACar.entities.concretes.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private ModelMapperService modelMapperService;
    private CustomerDao customerDao;

    public CustomerManager(ModelMapperService modelMapperService, CustomerDao customerDao) {
        this.modelMapperService = modelMapperService;
        this.customerDao = customerDao;
    }

    @Override
    public Result add(CreateCustomerRequest createCustomerRequest) {

        Customer customer=this.modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        customerDao.save(customer);

        return new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_ADDED);

    }

    @Override
    public Result delete(DeleteCustomerRequest deleteCustomerRequest) {

        this.customerDao.deleteById(deleteCustomerRequest.getId());

        return new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_DELETED);
    }

    @Override
    public Result update(UpdateCustomerRequest updateCustomerRequest) {

        Customer customer=this.modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
        this.customerDao.save(customer);

        return  new SuccessResult(BusinessMessages.CustomerMessages.CUSTOMER_UPDATED);

    }

    @Override
    public DataResult<List<ListCustomerDto>> getAll() {

        List<Customer> customers=this.customerDao.findAll();

        List<ListCustomerDto> response=customers.stream()
                .map(customer -> this.modelMapperService.forDto().map(customer,ListCustomerDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCustomerDto>>(response);
    }

    @Override
    public DataResult<CustomerDto> getById(int id) {

        Customer customer=this.customerDao.getById(id);
        CustomerDto customerDto=this.modelMapperService.forDto().map(customer,CustomerDto.class);

        return new SuccessDataResult<>(customerDto);
    }

    @Override
    public DataResult<CustomerDto> getByLastCustomer() {
        List<Customer> customers = this.customerDao.findAll();
        Customer customer = customers.get(customers.size() - 1);
        CustomerDto customerDto = this.modelMapperService.forDto().map(customer, CustomerDto.class);
        return new SuccessDataResult<CustomerDto>(customerDto);
    }

}
