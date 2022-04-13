package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.AdditionalServiceService;
import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalServiceResponses.AdditionalServiceDto;
import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/additionalservices")
public class AdditionalServicesController {

    private AdditionalServiceService additionalServiceService;

    public AdditionalServicesController(AdditionalServiceService additionalServiceService) {
        this.additionalServiceService = additionalServiceService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListAdditionalServiceDto>> getAll(){
        return additionalServiceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateAdditionalServiceRequest createAdditionalServiceRequests){
        return this.additionalServiceService.add(createAdditionalServiceRequests);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateAdditionalServiceRequest updateAdditionalServiceRequests){
        return this.additionalServiceService.update(updateAdditionalServiceRequests);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteAdditionalServiceRequest deleteAdditionalServiceRequests){
        return this.additionalServiceService.delete(deleteAdditionalServiceRequests);
    }

    @GetMapping("/getbyid")
    public DataResult<AdditionalServiceDto> getById(@RequestParam("id") int id){
        return additionalServiceService.getById(id);
    }
}
