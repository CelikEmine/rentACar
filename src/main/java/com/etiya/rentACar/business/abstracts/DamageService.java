package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface DamageService {

    Result add(CreateDamageRequest damageRequest);
    Result update(UpdateDamageRequest updateDamageRequest);
    Result delete(DeleteDamageRequest deleteDamageRequest);

    DataResult<List<ListDamageDto>> getAll();
    DataResult<DamageDto> getById(int id);
    DataResult<List<ListDamageDto>> getAllPaged(int pageNo, int pageSize);
    DataResult<List<ListDamageDto>> getAllSorted(String option,String field);
    DataResult<List<ListDamageDto>> getAllByCarId(int id);

}
