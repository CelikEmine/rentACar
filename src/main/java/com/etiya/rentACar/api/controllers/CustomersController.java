package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.CustomerService;
import com.etiya.rentACar.business.requests.CustomerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.DeleteCustomerRequest;
import com.etiya.rentACar.business.requests.CustomerRequests.UpdateCustomerRequest;
import com.etiya.rentACar.business.responses.customerResponses.CustomerDto;
import com.etiya.rentACar.business.responses.customerResponses.ListCustomerDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/src/customers")
public class CustomersController {

    private CustomerService customerService;

    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListCustomerDto>> getAll(){
        return customerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCustomerRequest createCustomerRequest){
        return this.customerService.add(createCustomerRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        return this.customerService.update(updateCustomerRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteCustomerRequest deleteCustomerRequest){
        return this.customerService.delete(deleteCustomerRequest);
    }

    @GetMapping("/getbyid")
    public DataResult<CustomerDto> getById(@RequestParam("id") int id){
        return customerService.getById(id);
    }


}
