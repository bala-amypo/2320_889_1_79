package com.example.demo.dto;

public class VehicleDTO {

    private Long id;
    private String vehicleNumber;
    private Double fuelEfficiency;
    private Double capacityKg;
    private Long userId;

    public VehicleDTO() {}

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

    public Long getUserId() {
        return userId;
    }

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
