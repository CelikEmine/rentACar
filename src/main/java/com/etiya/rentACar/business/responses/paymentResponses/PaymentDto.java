package com.etiya.rentACar.business.responses.paymentResponses;

import com.etiya.rentACar.business.responses.additionalServiceResponses.ListAdditionalServiceDto;
import com.etiya.rentACar.business.responses.invoiceResponses.ListInvoiceDto;
import com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses.ListRentalAdditionalServiceDetailDto;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private int id;

    /*private LocalDate rentDate;

    private LocalDate returnDate;*/


    private double totalPrice;

    private ListRentalDto listRentalDto;

    private ListInvoiceDto listInvoiceDto;

    private ListRentalAdditionalServiceDetailDto listRentalAdditionalServiceDetailDto;


}
