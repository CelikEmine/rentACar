package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ColorDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.Brand;
import com.etiya.rentACar.entities.concretes.Color;

import java.util.List;

public interface ColorService {

    Result add(CreateColorRequest createColorRequest);
    Result delete(DeleteColorRequest deleteColorRequest);
    Result update(UpdateColorRequest updateColorRequest);

    DataResult<List<ListColorDto>> getAll();
    DataResult<ColorDto> getById(int id);

}