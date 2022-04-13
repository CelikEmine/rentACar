package com.etiya.rentACar.business.responses.rentalResponses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListRentalDto {

    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private String customerFirstName;

    private String customerLastName;

    private String carBrandName;

    private String rentCityName;

    private String returnCityName;

    private double rentKilometer;

    private double dailyPrice;
}
