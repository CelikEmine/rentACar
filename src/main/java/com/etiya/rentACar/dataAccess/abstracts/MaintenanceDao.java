package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceDao extends JpaRepository<Maintenance,Integer> {

    List<Maintenance> getAllByCarId(int id);

}

