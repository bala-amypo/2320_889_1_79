package com.example.demo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleRequestDTO {

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNumber;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be positive")
    private Double capacityKg;

    @NotNull(message = "Fuel efficiency is required")
    @Min(value = 1, message = "Fuel efficiency must be positive")
    private Double fuelEfficiency;

    // Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
