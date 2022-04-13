package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.concretes.CarState;
import com.etiya.rentACar.entities.concretes.Rental;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalManager implements RentalService {

    private ModelMapperService modelMapperService;
    private RentalDao rentalDao;
    private CarService carService;

    public RentalManager(ModelMapperService modelMapperService, RentalDao rentalDao,CarService carService) {
        this.modelMapperService = modelMapperService;
        this.rentalDao = rentalDao;
        this.carService=carService;
    }


    @Override
    public DataResult<Rental> add(CreateRentalRequest createRentalRequest) {

        int carId=createRentalRequest.getCarId();

        carService.checkIfCarState(carId);
        Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        rental.setDailyPrice(this.setDiscountedPrice(carId));
        this.rentalDao.save(rental);

        carService.updateState(carId, CarState.Rented);

        return new SuccessDataResult<Rental>(rental,BusinessMessages.RentalMessages.RENTAL_ADDED);
    }

    @Override
    public Result delete(DeleteRentalRequest deleteRentalRequest) {

        this.rentalDao.deleteById(deleteRentalRequest.getId());

        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_DELETED);
    }

    @Override
    public Result update(UpdateRentalRequest updateRentalRequest) {

        Rental rental=this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
        this.rentalDao.save(rental);

        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_UPDATED);
    }

    @Override
    public DataResult<List<ListRentalDto>> getAll() {

        List<Rental> rentals=this.rentalDao.findAll();

        List<ListRentalDto> response=rentals.stream()
                .map(rental -> this.modelMapperService.forDto().map(rental,ListRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListRentalDto>>(response);
    }

    @Override
    public DataResult<RentalDto> getById(int id) {

        Rental rental=this.rentalDao.getById(id);
        RentalDto rentalDto=this.modelMapperService.forDto().map(rental,RentalDto.class);

        return new SuccessDataResult<>(rentalDto);
    }

    public double setDiscountedPrice(int carId){
        double discountRate = 0.5;
        CarDto carDto = this.carService.getById(carId).getData();
        return (carDto.getDailyPrice()*discountRate);
    }

}
