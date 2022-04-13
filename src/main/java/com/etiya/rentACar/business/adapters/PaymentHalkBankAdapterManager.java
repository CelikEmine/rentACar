package com.etiya.rentACar.business.adapters;

import com.etiya.rentACar.PayService.HalkBankPosManager;
import com.etiya.rentACar.entities.concretes.CreditCard;
import org.springframework.stereotype.Service;

@Service
public class PaymentHalkBankAdapterManager {

    //implements ederek çalıştırabiliriz

    private HalkBankPosManager halkBankPosManager;


    public PaymentHalkBankAdapterManager(HalkBankPosManager halkBankPosManager ) {
        this.halkBankPosManager = halkBankPosManager;

    }


    //    @Override
    public boolean pay(CreditCard creditCard) {
        return halkBankPosManager.pay(creditCard.getCardFirstName(), creditCard.getCardLastName(), creditCard.getCardNumber());
    }

}
