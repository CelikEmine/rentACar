package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalDao extends JpaRepository<Rental,Integer> {
        Rental getByCarId(int id);
}
