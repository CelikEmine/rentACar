package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/damages")
public class DamagesController {

    private DamageService damageService;

    public DamagesController(DamageService damageService) {
        this.damageService = damageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateDamageRequest createDamageRequest){
        return this.damageService.add(createDamageRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListDamageDto>> getAll(){
        return this.damageService.getAll();
    }

    @GetMapping("/getByCarId")
    public DataResult<List<ListDamageDto>> getByCarId(@RequestParam("carId") int id ){
        return this.damageService.getAllByCarId(id);
    }


    @GetMapping("/getallpages")
    public DataResult<List<ListDamageDto>> getAllPaged(int pageNo, int pageSize){
        return this.damageService.getAllPaged(pageNo,pageSize);

    }

    @GetMapping("/getallsorted")
    public DataResult<List<ListDamageDto>> getAllSorted(String option, String field){
        return this.damageService.getAllSorted(option,field);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateDamageRequest updateDamageRequest){
        return this.damageService.update(updateDamageRequest);
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDamageRequest deleteDamageRequest){
        return this.damageService.delete(deleteDamageRequest);
    }

    @GetMapping("/getById")
    public DataResult<DamageDto> getById(@RequestParam("id") int id ){
        return this.damageService.getById(id);
    }


}
