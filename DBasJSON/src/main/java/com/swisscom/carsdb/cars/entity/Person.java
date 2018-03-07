package com.swisscom.carsdb.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.swisscom.carsdb.cars.json.View;

import javax.persistence.*;
import java.util.List;

/**
 * @author Noel Oliveira
 * @since 06.03.2018
 * @version 1.0
 */

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Compact.class)
    private Integer personId;

    @JsonView(View.Compact.class)
    private String vorname;

    @JsonView(View.Compact.class)
    private String nachname;

    @JsonView(View.Compact.class)
    @OneToMany(targetEntity = Cars.class, mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("person")
    private List<Cars> _cars;

    public Person(String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Person() {

    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public List<Cars> get_cars() {
        return _cars;
    }

    public void set_cars(List<Cars> _cars) {
        this._cars = _cars;
    }

    @Override
    public String toString() {
        String returnString = "";

        returnString += "Person{" +
                "id=" + personId +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", _cars=" ;

        for(Cars car : _cars) {
            returnString += System.lineSeparator();
            returnString += car.toString();
        }

        returnString += '}';

        return returnString;

    }
}
