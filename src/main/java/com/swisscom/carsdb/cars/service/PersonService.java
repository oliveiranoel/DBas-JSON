package com.swisscom.carsdb.cars.service;

import com.swisscom.carsdb.cars.entity.Person;
import com.swisscom.carsdb.cars.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    PersonRepository personRepository;

    public Person saveOrUpdatePerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Integer PersonId) {
        return personRepository.findOne(PersonId);
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
