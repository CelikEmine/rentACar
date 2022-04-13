package com.etiya.rentACar.business.requests.rentalAdditionalServiceDetailRequests;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalAdditionalServiceDetailRequest {

    @JsonIgnore
    private int id;

    private int rentalId;

    private int additionalServiceId;

}
