package com.etiya.rentACar.business.responses.customerResponses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerDto {

    private int id;

    private String firstName;

    private String lastName;

}
