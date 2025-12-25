package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(unique = true)
    private String vehicleNumber;

    private Double capacityKg;
    private Double fuelEfficiency;

    public Vehicle(){}

    public Long getId(){ return id;}
    public User getUser(){ return user;}
    public void setUser(User u){ this.user=u;}
    public String getVehicleNumber(){ return vehicleNumber;}
    public void setVehicleNumber(String v){ this.vehicleNumber=v;}
    public Double getCapacityKg(){ return capacityKg;}
    public void setCapacityKg(Double c){ this.capacityKg=c;}
    public Double getFuelEfficiency(){ return fuelEfficiency;}
    public void setFuelEfficiency(Double f){ this.fuelEfficiency=f;}
}
