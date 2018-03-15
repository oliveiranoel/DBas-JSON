package com.swisscom.carsdb.cars.repository;

import com.swisscom.carsdb.cars.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Noel Oliveira
 * @since 06.03.2018
 * @version 1.0
 */

public interface CarsRepository extends JpaRepository<Cars, Integer> {

}
