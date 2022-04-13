package com.etiya.rentACar.business.requests.paymentRequests;

import com.etiya.rentACar.business.requests.CustomerRequests.CreateCustomerRequest;
import com.etiya.rentACar.business.requests.invoiceRequests.CreateInvoiceRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    @JsonIgnore
    private int id;

    @JsonIgnore
    private double totalPrice;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    private String cardExpirationDate;

    private String cvc;

   /* @JsonIgnore
    private int customerId;

    */

    private CreateInvoiceRequest createInvoiceRequest;

    private CreateRentalRequest createRentalRequest;

    private List<Integer> orderedAdditionalPropertyIdentities;

}
