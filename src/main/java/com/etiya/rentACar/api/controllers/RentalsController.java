package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

    private RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }


    @GetMapping("/getall")
    public DataResult<List<ListRentalDto>> getAll(){
        return rentalService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateRentalRequest createRentalRequest){
        return this.rentalService.add(createRentalRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateRentalRequest updateRentalRequest){
        return this.rentalService.update(updateRentalRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteRentalRequest deleteRentalRequest){
        return this.rentalService.delete(deleteRentalRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<RentalDto> getById(@RequestParam("id") int id){
        return rentalService.getById(id);
    }
}
