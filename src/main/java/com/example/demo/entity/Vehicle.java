package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String model;
    private Double capacityKg;

    public Vehicle() {}

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }
}
