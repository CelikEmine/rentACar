package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.constants.messages.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.MaintenanceDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.concretes.CarState;
import com.etiya.rentACar.entities.concretes.Maintenance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaintenanceManager implements MaintenanceService {

    private MaintenanceDao maintenanceDao;
    private ModelMapperService modelMapperService;
    private CarService carService;

    public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService,CarService carService) {
        this.maintenanceDao = maintenanceDao;
        this.modelMapperService = modelMapperService;
        this.carService=carService;
    }

    @Override
    public Result add(CreateMaintenanceRequest createMaintenanceRequest) {

        int carId=createMaintenanceRequest.getCarId();

        this.carService.checkIfCarState(carId);

        Maintenance maintenance=this.modelMapperService.forRequest().map(createMaintenanceRequest,Maintenance.class);
        maintenanceDao.save(maintenance);

        this.carService.updateState(carId,CarState.UnderMaintanance);

        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_ADDED);
    }

    @Override
    public DataResult<List<ListMaintenanceDto>> getAll() {

        List<Maintenance> maintenances=this.maintenanceDao.findAll();

        List<ListMaintenanceDto> responce=maintenances.stream()
                .map(maintenance -> this.modelMapperService.forDto().map(maintenance,ListMaintenanceDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(responce);

    }


    @Override
    public DataResult<List<ListMaintenanceDto>> getByCarId(int carId) {

        List<Maintenance> maintenances = this.maintenanceDao.getAllByCarId(carId);

        List<ListMaintenanceDto> response=maintenances.stream()
                .map(maintenance -> this.modelMapperService.forDto().map(maintenance,ListMaintenanceDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<>(response);
    }

    @Override
    public Result update(UpdateMaintenanceRequest updateMaintenanceRequest) {

        Maintenance maintenance=this.modelMapperService.forRequest().map(updateMaintenanceRequest,Maintenance.class);
        this.maintenanceDao.save(maintenance);

        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_UPDATED);
    }

    @Override
    public Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest) {

        this.maintenanceDao.deleteById(deleteMaintenanceRequest.getId());

        return new SuccessResult(BusinessMessages.MaintenanceMessages.MAINTENANCE_DELETED);
    }

    @Override
    public DataResult getById(int id) {

        Maintenance result=this.maintenanceDao.getById(id);
        MaintenanceDto response=this.modelMapperService.forDto().map(result,MaintenanceDto.class);

        return new SuccessDataResult(response);
    }


}
