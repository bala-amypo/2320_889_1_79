package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private Double fuelEfficiency;
    private Double capacityKg;

    @ManyToOne
    private User user;

    // getters & setters
}
