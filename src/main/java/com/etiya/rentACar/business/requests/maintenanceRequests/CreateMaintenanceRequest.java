package com.etiya.rentACar.business.requests.maintenanceRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {

    @JsonIgnore
    private int id;

    private int carId;

    private LocalDate dateAdded;

    private String description;

}
