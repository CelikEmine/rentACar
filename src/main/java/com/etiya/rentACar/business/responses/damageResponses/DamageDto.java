package com.etiya.rentACar.business.responses.damageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageDto {

    private int id;

    private int carId;

    private String description;

    private LocalDate date;

}
