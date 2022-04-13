package com.etiya.rentACar.business.abstracts;

import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.Rental;

import java.util.List;

public interface RentalService {

    DataResult<Rental> add(CreateRentalRequest createRentalRequest);
    Result delete(DeleteRentalRequest deleteRentalRequest);
    Result update(UpdateRentalRequest updateRentalRequest);

    DataResult<List<ListRentalDto>> getAll();
    DataResult<RentalDto> getById(int id);
}
