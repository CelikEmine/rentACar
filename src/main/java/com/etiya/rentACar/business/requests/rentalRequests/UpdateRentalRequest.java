package com.etiya.rentACar.business.requests.rentalRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    private int id;

    private int customerId;

    private int carId;

    private int rentCityId;

    private int returnCityId;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private double rentKilometer;

}
