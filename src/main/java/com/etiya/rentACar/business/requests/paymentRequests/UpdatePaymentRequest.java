package com.etiya.rentACar.business.requests.paymentRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePaymentRequest {

    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    private String cardExpirationDate;

    private String cvc;

    private int customerId;

    private int carId;

    private int returnCityId;

    private int rentCityId;

    private List<Integer> orderedAdditionalPropertyIdentities;

}
