package com.swisscom.carsdb.cars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.*;
import com.swisscom.carsdb.cars.json.View;

/**
 * @author Noel Oliveira
 * @since 06.03.2018
 * @version 1.0
 */

@Entity
public class Cars {

    @Id
    @JsonView(View.Compact.class)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carsId;

    @JsonView(View.Compact.class)
    private String marke;

    @JsonView(View.Compact.class)
    private String modell;

    @JsonView(View.Compact.class)
    private int ps;

    @JsonView(View.Compact.class)
    private int preis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    @JsonIgnoreProperties("_cars")
    private Person person;


    public Cars(String marke, String modell, int ps, int preis) {
        this.marke = marke;
        this.modell = modell;
        this.ps = ps;
        this.preis = preis;
    }

    public Cars() {

    }

    public Integer getCarsId() {
        return carsId;
    }

    public void setCarsId(Integer carsId) {
        this.carsId = carsId;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "carsId=" + carsId +
                ", marke='" + marke + '\'' +
                ", modell='" + modell + '\'' +
                ", ps=" + ps +
                ", preis=" + preis +
                ", personId'" + person.getPersonId() +
                '}';
    }
}
