package com.etiya.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    private String expirationDate;

    private String cvc;
}
