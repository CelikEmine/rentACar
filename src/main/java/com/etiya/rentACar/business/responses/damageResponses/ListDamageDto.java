package com.etiya.rentACar.business.responses.damageResponses;

import com.etiya.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListDamageDto {

    private int id;

    private int carId;

    private String description;

    private LocalDate date;

}

