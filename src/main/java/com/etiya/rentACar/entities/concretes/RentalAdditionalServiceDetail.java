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
@Table(name="rentaladditionalservicedetails")
public class RentalAdditionalServiceDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;

    @ManyToOne
    @JoinColumn(name="additionalservice_id")
    private AdditionalService additionalservice;

    /*
    @OneToMany(mappedBy = "rentalAdditionalServiceDetail")
    private List<Payment> payments; */
}
