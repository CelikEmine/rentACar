package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.BrandDto;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface BrandService {

    Result add(CreateBrandRequest createBrandRequest);
    Result delete(DeleteBrandRequest deleteBrandRequest);
    Result update(UpdateBrandRequest updateBrandRequest);

    DataResult<List<ListBrandDto>> getAll();
    DataResult<BrandDto> getById(int id);

}
