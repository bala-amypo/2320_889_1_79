package com.example.demo.entity;
import jakarta.persistence.*;
public class Vehicle{
    @Id
    private Long id;
    @Column(unique=true)
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;


}