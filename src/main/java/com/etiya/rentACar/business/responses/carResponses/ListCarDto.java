package com.etiya.rentACar.business.responses.carResponses;

import com.etiya.rentACar.entities.concretes.Brand;
import com.etiya.rentACar.entities.concretes.CarState;
import com.etiya.rentACar.entities.concretes.Color;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {

    private int id;

    private double modelYear;

    private String colorName;

    private String brandName;

    private double dailyPrice;

    private CarState carState;

    private String cityName;

    private String description;

    private double kilometer;


}
