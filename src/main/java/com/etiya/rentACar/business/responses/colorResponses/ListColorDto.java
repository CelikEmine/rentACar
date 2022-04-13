package com.etiya.rentACar.business.responses.colorResponses;

import com.etiya.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListColorDto {

    private int id;

    private String name;

}