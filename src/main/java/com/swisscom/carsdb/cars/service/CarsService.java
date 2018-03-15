package com.swisscom.carsdb.cars.service;

import com.swisscom.carsdb.cars.entity.Cars;
import com.swisscom.carsdb.cars.repository.CarsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Noel Oliveira
 * @since 06.03.2018
 * @version 1.0
 */
@Service
public class CarsService {

    private static final Logger logger = LoggerFactory.getLogger(CarsService.class);

    @Autowired
    CarsRepository carsRepository;

    public Cars saveOrUpdateCars(Cars cars) {
        return carsRepository.save(cars);
    }

    public Cars getCarsById(Integer CarsId) {
        return carsRepository.findOne(CarsId);
    }

    public List<Cars> getAllCars() {
        return carsRepository.findAll();
    }
}
