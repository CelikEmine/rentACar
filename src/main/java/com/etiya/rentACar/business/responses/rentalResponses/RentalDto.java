package com.etiya.rentACar.business.responses.rentalResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {

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
