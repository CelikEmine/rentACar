package com.etiya.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "rentCity_Id", referencedColumnName = "id")
    private City rentCity;

    @ManyToOne
    @JoinColumn(name = "returnCity_Id", referencedColumnName = "id")
    private City returnCity;

    @Column(name = "rentDate")
    private LocalDate rentDate;

    @Column(name = "returnDate")
    private LocalDate returnDate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name="rentKilometer")
    private double rentKilometer;

    @OneToMany(mappedBy = "rental")
    private List<RentalAdditionalServiceDetail> rentalAdditionalServiceDetail;

    @OneToMany(mappedBy="rental")
    private List<Payment> payments;

    @OneToMany(mappedBy="rental")
    private List<Invoice> invoices;

}
