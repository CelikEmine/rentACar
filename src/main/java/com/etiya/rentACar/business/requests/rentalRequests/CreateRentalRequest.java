package com.etiya.rentACar.business.requests.rentalRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalRequest {

    @JsonIgnore
    private int id;


    private int customerId;

    @NotNull
    private int carId;

    @NotNull
    private int rentCityId;

    @NotNull
    private int returnCityId;

    @NotNull
    private LocalDate rentDate;

    @NotNull
    private LocalDate returnDate;

    private double rentKilometer;

    @JsonIgnore
    private double dailyPrice;

}
