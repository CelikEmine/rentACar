package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.CreateRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.DeleteRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests.UpdateRentalAdditionalServiceDetailRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.ListRentalAdditionalServiceDetailDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.RentalAdditionalServiceDetailDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.entities.concretes.AdditionalService;

import java.util.List;
import java.util.stream.Collectors;

public interface RentalAdditionalServiceDetailService {

    Result add(CreateRentalAdditionalServiceDetailRequest createRentalAdditionalServiceDetailRequest);
    Result delete(DeleteRentalAdditionalServiceDetailRequest deleteRentalAdditionalServiceDetailRequest);
    Result update(UpdateRentalAdditionalServiceDetailRequest updateRentalAdditionalServiceDetailRequest);

    DataResult<List<ListRentalAdditionalServiceDetailDto>> getAll();
    DataResult<RentalAdditionalServiceDetailDto> getById(int id);

    DataResult<List<ListRentalAdditionalServiceDetailDto>> getByRentalId(int rentalId);
    DataResult<List<ListRentalAdditionalServiceDetailDto>> getByAdditionalserviceId(int additionalServiceId);



}
