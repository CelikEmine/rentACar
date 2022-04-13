package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ColorDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.concretes.Color;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {

    private ColorService colorService;

    //@Autowired-----artık gerek yok kendi arka planda yapıyor reflection
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListColorDto>> getAll() {
        return colorService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateColorRequest createColorRequest) {
        return this.colorService.add(createColorRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateColorRequest updateColorRequest) {
       return this.colorService.update(updateColorRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteColorRequest deleteColorRequest) {
        return this.colorService.delete(deleteColorRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<ColorDto> getById(@RequestParam("id") int id) {
        return colorService.getById(id);
    }


}


