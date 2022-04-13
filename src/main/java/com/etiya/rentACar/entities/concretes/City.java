package com.etiya.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Car> cars;

    @OneToMany(mappedBy = "rentCity")
    private List<Rental> rentRentalCities;

    @OneToMany(mappedBy = "returnCity")
    private List<Rental> returnRentalCities;

    /*@OneToMany(mappedBy = "rentCity")
    private List<Payment> rentPaymentCities;

    @OneToMany(mappedBy = "returnCity")
    private List<Payment> returnPaymentCities;*/

}
