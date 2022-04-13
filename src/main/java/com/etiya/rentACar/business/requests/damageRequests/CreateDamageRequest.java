package com.etiya.rentACar.business.requests.damageRequests;

import com.etiya.rentACar.entities.concretes.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDamageRequest {

    @JsonIgnore
    private int id;

    private int carId;

    private String description;

    private LocalDate date;

}
