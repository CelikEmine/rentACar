package com.etiya.rentACar.business.abstracts;


import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface AdditionalServiceService {

    Result add(CreateAdditionalServiceRequest createAdditionalServiceRequests);
    Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequests);
    Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequests);

    DataResult<List<ListAdditionalServiceDto>> getAll();
    DataResult<AdditionalServiceDto> getById(int id);

}
