package com.etiya.rentACar.business.responses.cityResponses;

import com.etiya.rentACar.entities.concretes.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private int id;

    private String name;

}
