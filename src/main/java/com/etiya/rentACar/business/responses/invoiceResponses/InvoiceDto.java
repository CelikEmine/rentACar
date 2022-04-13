package com.etiya.rentACar.business.responses.invoiceResponses;

import com.etiya.rentACar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private int id;

    private String invoiceNumber;

    private LocalDate createDate;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int dayCount;

    private double totalPrice;

    private String customerFirstName;

    private String customerLastName;

}
