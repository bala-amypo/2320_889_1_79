package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double distance;

    @ManyToOne
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
