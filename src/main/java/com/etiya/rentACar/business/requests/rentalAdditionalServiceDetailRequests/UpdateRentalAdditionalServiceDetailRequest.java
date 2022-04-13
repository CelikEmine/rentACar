package com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalAdditionalServiceDetailRequest {

    private int id;

    private int rentalId;

    private int additionalServiceId;

}
