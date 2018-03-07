package com.swisscom.carsdb.cars.config;

import com.swisscom.carsdb.cars.entity.Cars;
import com.swisscom.carsdb.cars.entity.Person;
import com.swisscom.carsdb.cars.repository.CarsRepository;
import com.swisscom.carsdb.cars.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private PersonRepository personRepository;

    // API
    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        final Person person = new Person();
        person.setPersonId(1);
        person.setVorname("Noel");
        person.setNachname("Oliveira");
        personRepository.save(person);

        final Person person1 = new Person();
        person1.setPersonId(2);
        person1.setVorname("Nico");
        person1.setNachname("Rimle");
        personRepository.save(person1);

        final Cars car = new Cars();
        car.setCarsId(1);
        car.setMarke("VW");
        car.setModell("Polo GTI");
        car.setPs(192);
        car.setPreis(20000);
        car.setPerson(person);
        carsRepository.save(car);

        final Cars car1 = new Cars();
        car1.setCarsId(2);
        car1.setMarke("BMW");
        car1.setModell("M4");
        car1.setPs(431);
        car1.setPreis(80000);
        car1.setPerson(person1);
        carsRepository.save(car1);


        alreadySetup = true;

    }
}
