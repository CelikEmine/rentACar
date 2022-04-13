package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice,Integer> {

    List<Invoice> getByCreateDateBetween(LocalDate firstDate,LocalDate endDate);

    List<Invoice> getByCustomerId(int id);

}
