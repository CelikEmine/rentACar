package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.concretes.RentalAdditionalServiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalAdditionalServiceDetailDao extends JpaRepository<RentalAdditionalServiceDetail,Integer> {

    List<RentalAdditionalServiceDetail> getByRentalId(int rentalId);

    List<RentalAdditionalServiceDetail> getByAdditionalserviceId(int additionalServiceId);


}
