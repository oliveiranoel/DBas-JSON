package com.swisscom.carsdb.cars.controller;

import com.swisscom.carsdb.cars.entity.Cars;
import com.swisscom.carsdb.cars.entity.Person;
import com.swisscom.carsdb.cars.service.CarsService;
import com.swisscom.carsdb.cars.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Noel Oliveira
 * @version 1.0
 * @since 06.03.2018
 */

@RestController
@RequestMapping("/cars")
public class CarsController {

    private static final Logger logger = LoggerFactory.getLogger(CarsController.class);

    @Autowired
    CarsService carsService;


    //---------------- HTTP GET ---------------------------

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Cars> getAllCars() {
        return carsService.getAllCars();
    }

    @RequestMapping(value = "/{carsId}", method = RequestMethod.GET)
    public Cars getCarsById(@PathVariable Integer carsId) {
        return carsService.getCarsById(carsId);
    }


    //---------------- HTTP POST ---------------------------

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    ResponseEntity saveCars(@RequestBody Cars input) {
        try {
            if (carsService.saveOrUpdateCars(input) != null) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //---------------- HTTP POST ---------------------------

    @RequestMapping(value = "/{carsId}", method = RequestMethod.POST)
    ResponseEntity updateCars(@PathVariable Integer carsId, @RequestBody Cars input) {
        try {
            input.setCarsId(carsId);
            if (carsService.saveOrUpdateCars(input) != null) {
                return new ResponseEntity(HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
