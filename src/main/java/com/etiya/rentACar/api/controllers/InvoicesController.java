package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.InvoiceService;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.DeleteInvoiceRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.UpdateInvoiceRequest;
import com.etiya.rentACar.business.responses.invoiceResponses.InvoiceDto;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    private InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/getall")
    public DataResult<List<ListInvoiceDto>> getAll(){
        return invoiceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateInvoiceRequest createInvoiceRequest){
        return this.invoiceService.add(createInvoiceRequest);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UpdateInvoiceRequest updateInvoiceRequest){
        return this.invoiceService.update(updateInvoiceRequest);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteInvoiceRequest deleteInvoiceRequest){
        return this.invoiceService.delete(deleteInvoiceRequest);
    }

    @GetMapping("/getallcreatedate")
    public DataResult<List<ListInvoiceDto>> getAllCreateDate(@RequestParam("firstcreatedate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstCreateDate, @RequestParam("endcreatedate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endCreateDate){
        return invoiceService.getAllCreateDateBetween(firstCreateDate,endCreateDate);
    }

    @GetMapping("/getallcustomerid")
    public DataResult<List<ListInvoiceDto>> getAllCustomerId(@RequestParam("customerId")int customerId){
        return invoiceService.getByCustomerId(customerId);
    }

    @GetMapping("/getbyid")
    public DataResult<InvoiceDto> getById(@RequestParam("id")int id){
        return invoiceService.getById(id);
    }

}
