package com.etiya.rentACar.business.requests.invoiceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

    @JsonIgnore
    private int id;

    private String invoiceNumber;

    private LocalDate createDate;

    @JsonIgnore
    private LocalDate rentDate;

    @JsonIgnore
    private LocalDate returnDate;

    @JsonIgnore
    private int dayCount;

    @JsonIgnore
    private double totalPrice;

    private int customerId;

    @JsonIgnore
    private int rentalId;

    @JsonIgnore
    private double totalPricePayment;
}
