package com.etiya.rentACar.business.requests.carRequests;

import com.etiya.rentACar.entities.concretes.CarState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStateRequest {

    private int id;

    private double modelYear;

    private int colorId;

    private int brandId;

    private double dailyPrice;

    private CarState carState;

    private int cityId;

    private String description;

}
