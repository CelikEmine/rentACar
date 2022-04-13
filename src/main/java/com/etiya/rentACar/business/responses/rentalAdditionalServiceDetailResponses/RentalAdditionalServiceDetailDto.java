package com.etiya.rentACar.business.responses.rentalAdditionalServiceDetailResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalAdditionalServiceDetailDto {

    private int id;

    private int rentalId;

    private int additionalServiceId;

}

