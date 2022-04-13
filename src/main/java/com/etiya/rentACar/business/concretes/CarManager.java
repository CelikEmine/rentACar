package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateStateRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.entities.concretes.Car;
import com.etiya.rentACar.entities.concretes.CarState;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {


    private CarDao carDao;
    private ModelMapperService modelMapperService;

    public CarManager(CarDao carDao,ModelMapperService modelMapperService) {
        this.carDao = carDao;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public Result add(CreateCarRequest createCarRequest){

        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);
        this.carDao.save(car);

        return new SuccessResult(BusinessMessages.CarMessages.CAR_ADDED);

    }

    @Override
    public Result update(UpdateCarRequest updateCarRequest) {

        checkIfCarIdExist(updateCarRequest.getId());

        Car car=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carDao.save(car);

        return new SuccessResult(BusinessMessages.CarMessages.CAR_UPDATED);

    }

    @Override
    public Result delete(DeleteCarRequest deleteCarRequest) {

        checkIfCarIdExist(deleteCarRequest.getId());

        this.carDao.deleteById(deleteCarRequest.getId());

        return new SuccessResult(BusinessMessages.CarMessages.CAR_DELETED);
    }

    @Override
    public DataResult<List<ListCarDto>> getAll() {

        List<Car> cars=this.carDao.findAll();

        List<ListCarDto> response=cars.stream()
                .map(car -> this.modelMapperService.forDto().map(car,ListCarDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response,BusinessMessages.CarMessages.CAR_LISTED);
    }

    @Override
    public DataResult<List<ListCarDto>> getAllByModelYear(double modelYear) {

        List<Car> cars=this.carDao.getByModelYear(modelYear);

        List<ListCarDto> response=cars.stream()
                .map(car -> this.modelMapperService.forDto().map(car,ListCarDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<>(response);

    }

    @Override
    public DataResult<List<ListCarDto> > getAllPaged(int pageNo, int pageSize) {

        Pageable pageable= PageRequest.of(pageNo-1,pageSize);

        List<Car> cars= this.carDao.findAll(pageable).getContent();

        List<ListCarDto> response=cars.stream()
                .map(car -> this.modelMapperService.forDto().map(car,ListCarDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<>(response);

    }

    @Override
    public DataResult<List<ListCarDto>> getAllSorted() {

        Sort sort=Sort.by(Sort.Direction.DESC,"modelYear");

        List<Car> cars= this.carDao.findAll(sort);

        List<ListCarDto> response=cars.stream()
                .map(car -> this.modelMapperService.forDto().map(car,ListCarDto.class))
                .collect(Collectors.toList());

        return  new SuccessDataResult<>(response);
    }

    @Override
    public DataResult<CarDto> getById(int id) {

        Car car=this.carDao.getById(id);
        CarDto carDto = this.modelMapperService.forRequest().map(car, CarDto.class);

        return new SuccessDataResult<>(carDto);
    }

    @Override
    public DataResult<List<ListCarDto>> getByCityId(int cityId) {

        List<Car> cars=this.carDao.getByCityId(cityId);

        List<ListCarDto> response=cars.stream()
                .map(car -> this.modelMapperService.forDto().map(car,ListCarDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarDto>>(response);
    }

    @Override
    public void updateState(int carId,CarState carState) {

        Car car=this.carDao.getById(carId);

        UpdateStateRequest updateStateRequest=this.modelMapperService.forRequest().map(car,UpdateStateRequest.class);
        updateStateRequest.setCarState(carState);

        car = this.modelMapperService.forRequest().map(updateStateRequest, Car.class);
        this.carDao.save(car);
    }

    @Override
    public void updateKilometer(int carId, double kilometer) {

        Car car=this.carDao.getById(carId);

        UpdateCarRequest updateCarRequest=this.modelMapperService.forRequest().map(car,UpdateCarRequest.class);
        updateCarRequest.setKilometer(kilometer);

    }

    private void checkIfCarIdExist(int carId){
        if(this.carDao.getById(carId)==null){
            throw new BusinessException(BusinessMessages.CarMessages.NOT_EXIST_BEFORE);
        }
    }

    public void checkIfCarState(int carId){

        DataResult<CarDto> CarDto  = this.getById(carId);

        if(CarDto.getData().getCarState()==CarState.UnderMaintanance){
            throw new BusinessException(BusinessMessages.CarMessages.CAR_UNDERMAINTANANCE);
        }
        else if(CarDto.getData().getCarState()==CarState.Rented){
            throw new BusinessException(BusinessMessages.CarMessages.CAR_RENTED);
        }
    }

}
