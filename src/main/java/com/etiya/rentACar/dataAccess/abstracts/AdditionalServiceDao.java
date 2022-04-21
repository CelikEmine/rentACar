package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.concretes.AdditionalService;
import com.etiya.rentACar.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionalServiceDao extends JpaRepository<AdditionalService,Integer> {

    List<AdditionalService> getByNameIgnoreCase(String name);
}
