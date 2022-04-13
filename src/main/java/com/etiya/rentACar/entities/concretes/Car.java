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
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "stateId")
    private CarState carState;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "modelYear")
    private double modelYear;

    @Column(name="kilometer")
    private double kilometer;

    @OneToMany(mappedBy = "car")
    private List<Damage> damages;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    /*@OneToMany(mappedBy = "car")
    private List<Payment> payments;*/

}
