package com.swisscom.carsdb.cars.repository;

import com.swisscom.carsdb.cars.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Noel Oliveira
 * @since 06.03.2018
 * @version 1.0
 */

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
