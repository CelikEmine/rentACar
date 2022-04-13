package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CityService;
import com.etiya.rentACar.business.requests.cityRequests.CreateCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.DeleteCityRequest;
import com.etiya.rentACar.business.requests.cityRequests.UpdateCityRequest;
import com.etiya.rentACar.business.responses.cityResponses.CityDto;
import com.etiya.rentACar.business.responses.cityResponses.ListCityDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListCityDto>> getAll(){
        return cityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCityRequest createCityRequest){
        return this.cityService.add(createCityRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateCityRequest updateCityRequest){
        return this.cityService.update(updateCityRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCityRequest deleteCityRequest){
        return this.cityService.delete(deleteCityRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<CityDto> getById(@RequestParam("id") int id){
        return cityService.getById(id);
    }


}
