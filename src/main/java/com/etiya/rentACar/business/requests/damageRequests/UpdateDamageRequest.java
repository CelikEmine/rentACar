package com.etiya.rentACar.business.requests.damageRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDamageRequest {

    private int id;

    private int carId;

    private String description;

    private LocalDate date;

}
