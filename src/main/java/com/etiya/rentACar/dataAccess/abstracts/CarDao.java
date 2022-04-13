package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car,Integer> {

    List<Car> getByModelYear(double modelYear);
    List<Car> getByCityId(int cityId);

    List<Car> getByModelYearIn(List<Double> modelYears);
    List<Car> getByModelYearAndDailyPrice(double modelYear,double dailyPrice);
    List<Car> getByDescriptionContains(String description);

}
