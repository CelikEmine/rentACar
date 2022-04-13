package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.DeleteBrandRequest;
import com.etiya.rentACar.business.requests.brandRequests.UpdateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.BrandDto;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    //@Autowired-----artık gerek yok kendi arka planda yapıyor reflection
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListBrandDto>> getAll(){
       return brandService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateBrandRequest createBrandRequest){
        return this.brandService.add(createBrandRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateBrandRequest updateBrandRequest){
        return this.brandService.update(updateBrandRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest){
        return this.brandService.delete(deleteBrandRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<BrandDto> getById(@RequestParam("id") int id){
        return brandService.getById(id);
    }

}
