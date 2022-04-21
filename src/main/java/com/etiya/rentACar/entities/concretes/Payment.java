package com.etiya.rentACar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    /*@Column(name="rentDate")
    private LocalDate rentDate;

    @Column(name="returnDate")
    private LocalDate returnDate;*/

    @Column(name="totalPrice")
    private double totalPrice;

    @Column(name="cardNumber")
    private String cardNumber;

    @Column(name="cardFirstName")
    private String cardFirstName;

    @Column(name="cardLastName")
    private String cardLastName;

    @Column(name="cardExpirationDate")
    private String cardExpirationDate;

    @Column(name="cvc")
    private String cvc;

    @Column(name="dayCount")
    private int dayCount;

    /*@ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private Customer customer; */

    /*
    @ManyToOne
    @JoinColumn(name="returnCityId",referencedColumnName = "id")
    private City returnCity;

    @ManyToOne
    @JoinColumn(name="rentCityId",referencedColumnName = "id")
    private City rentCity;



    @ManyToOne
    @JoinColumn(name="rentalAdditionalServiceDetail_id")
    private RentalAdditionalServiceDetail rentalAdditionalServiceDetail;
*/

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;

}
