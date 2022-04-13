package com.etiya.rentACar.business.responses.additionalServiceResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalServiceDto {

    private int id;

    private String name;

    private double dailyPrice;

}
