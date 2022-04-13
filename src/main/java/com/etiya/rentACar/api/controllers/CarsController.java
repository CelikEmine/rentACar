package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.Car;
import com.etiya.rentACar.entities.concretes.Color;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    private CarService carService;

    //@Autowired-----artık gerek yok kendi arka planda yapıyor reflection
    public CarsController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {
        return this.carService.add(createCarRequest);
    }

    @GetMapping("/getall")
    public DataResult<List<ListCarDto>> getAll() {
        return carService.getAll();
    }

    @GetMapping("/getallbymodelyear")
    public DataResult<List<ListCarDto>> getAllByModelYear(@RequestParam("modelYear") double modelYear) {
        return carService.getAllByModelYear(modelYear);
    }

    @GetMapping("/getallpages")
    public DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize){
        return this.carService.getAllPaged(pageNo,pageSize);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<ListCarDto>> getAllSorted(){
        return  this.carService.getAllSorted();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateCarRequest updateCarRequest) {
        return this.carService.update(updateCarRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCarRequest deleteCarRequest) {
        return this.carService.delete(deleteCarRequest);
    }

    @GetMapping("/getbyall")
    public DataResult<CarDto> getById(int id) {
        return carService.getById(id);
    }

    @GetMapping("/getbycityid")
    public DataResult<List<ListCarDto>> getByCityId(int cityId) {
        return carService.getByCityId(cityId);
    }

}
