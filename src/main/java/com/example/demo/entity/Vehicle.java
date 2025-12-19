package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_number", nullable = false, unique = true)
    private String vehicleNumber;

    @Column(name = "fuel_efficiency", nullable = false)
    private Double fuelEfficiency;

    @Column(name = "capacity_kg", nullable = false)
    private Double capacityKg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /* ---------------- Constructors ---------------- */

    public Vehicle() {
    }

    /* ---------------- Getters ---------------- */

    public Long getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public User getUser() {
        return user;
    }

    /* ---------------- Setters ---------------- */

    public void setId(Long id) {
        this.id = id;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
