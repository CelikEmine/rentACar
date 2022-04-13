package com.etiya.rentACar.business.requests.invoiceRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {

    private int id;

    private String invoiceNumber;

    private LocalDate createDate;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int dayCount;

    private double totalPrice;

    private int customerId;

}
