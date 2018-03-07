package com.swisscom.carsdb.cars.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.swisscom.carsdb.cars.entity.Cars;
import com.swisscom.carsdb.cars.entity.Person;
import com.swisscom.carsdb.cars.json.View;
import com.swisscom.carsdb.cars.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Api(value = "Person Service", tags = "Person")
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    // ----------------- HTTP GET ---------------------------------------------
    @ApiOperation(value = "Get all Persons from database",
            notes = "Provides all Person Objects including the cars as an array")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @JsonView(View.Compact.class)
    public List<Person> getAllPerson(@RequestParam(value="car", required=false, defaultValue = "true") Boolean withCar) {

        if (withCar) {
            return personService.getAllPerson();
        }
        else
        {
            List<Person> person = personService.getAllPerson();
            // Verlinke die Cars mit der Person
            for (Person pers: person)
                pers.set_cars(null);

            return person;
        }

    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    @JsonView(View.Compact.class)
    public Person getPersonById(@PathVariable Integer personId) {
        return personService.getPersonById(personId);
    }


    // ----------------- HTTP POST ---------------------------------------------

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    ResponseEntity savePerson(@RequestBody Person input) {

        try {

            // Verlinke die Cars mit der Person
            for (Cars car: input.get_cars())
                car.setPerson(input);

            if (personService.saveOrUpdatePerson(input) != null) {
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ----------------- HTTP PUT ---------------------------------------------

    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT)
    ResponseEntity updatePerson(@PathVariable Integer personId, @RequestBody Person input) {

        try {
            // Verlinke den Person mit einem Objekt
            input.setPersonId(personId);

            // Verlinke die Adresse mit dem Kunden
            for (Cars car: input.get_cars())
                car.setPerson(input);

            if (personService.saveOrUpdatePerson(input) != null) {
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
