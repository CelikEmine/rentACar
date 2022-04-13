package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.MaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface MaintenanceService {

    Result add(CreateMaintenanceRequest createMaintenanceRequest);
    Result update(UpdateMaintenanceRequest updateMaintenanceRequest);
    Result delete(DeleteMaintenanceRequest deleteMaintenanceRequest);

    DataResult<MaintenanceDto> getById(int id);
    DataResult<List<ListMaintenanceDto>> getByCarId(int carId);
    DataResult<List<ListMaintenanceDto>> getAll();

}
