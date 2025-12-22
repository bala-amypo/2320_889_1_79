package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vehicle number is required")
    @Column(unique = true)
    private String vehicleNumber;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Capacity is required")
    private Double capacityKg;

    public Vehicle() {}

    public Vehicle(Long id, String vehicleNumber, String model, Double capacityKg) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.capacityKg = capacityKg;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Double getCapacityKg() { return capacityKg; }
    public void setCapacityKg(Double capacityKg) { this.capacityKg = capacityKg; }
}