package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.brandResponses.BrandDto;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.cityResponses.CityDto;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import java.util.List;

public interface CityService {

    Result add(CreateCityRequest createCityRequest);
    Result delete(DeleteCityRequest deleteCityRequest);
    Result update(UpdateCityRequest updateCityRequest);

    DataResult<List<ListCityDto>> getAll();
    DataResult<CityDto> getById(int id);
}
