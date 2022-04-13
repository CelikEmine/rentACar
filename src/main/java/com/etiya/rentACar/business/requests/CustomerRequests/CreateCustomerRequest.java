package com.etiya.rentACar.business.requests.CustomerRequests;

import com.etiya.rentACar.entities.concretes.Rental;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    @JsonIgnore
    private int id;

    private String firstName;

    private String lastName;


}
