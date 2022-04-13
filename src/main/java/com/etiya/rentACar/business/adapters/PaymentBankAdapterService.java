package com.etiya.rentACar.business.adapters;

import com.etiya.rentACar.entities.concretes.CreditCard;

public interface PaymentBankAdapterService {
    public boolean pay(CreditCard creditCard);
}
