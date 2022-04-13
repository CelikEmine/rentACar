package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.responses.paymentResponses.ListPaymentDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreatePaymentRequest createPaymentRequest) {
        return this.paymentService.add(createPaymentRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListPaymentDto>> getAll() {
        return this.paymentService.getALl();
    }

}