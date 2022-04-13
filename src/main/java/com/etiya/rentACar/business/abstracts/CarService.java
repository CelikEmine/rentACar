package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.CarState;

import java.util.List;

public interface CarService {

    Result add(CreateCarRequest createCarRequest);
    Result update(UpdateCarRequest updateCarRequest);
    Result delete(DeleteCarRequest deleteCarRequest);

    DataResult<List<ListCarDto>> getAll();
    DataResult<List<ListCarDto>> getAllByModelYear(double modelYear);
    DataResult<List<ListCarDto>> getAllPaged(int pageNo,int pageSize);
    DataResult<List<ListCarDto>> getAllSorted();

    DataResult<CarDto> getById(int id);
    DataResult<List<ListCarDto>> getByCityId(int cityId);

    void updateState(int carId, CarState carState);
    void updateKilometer(int carId,double kilometer);
    void checkIfCarState(int carId);

}
