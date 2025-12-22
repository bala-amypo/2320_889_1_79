package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {

    private Long id;

    @NotBlank(message = "Vehicle number is required")
    private String vehicleNumber;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Capacity is required")
    private Double capacityKg;

    public VehicleDTO() {}

    public VehicleDTO(Long id, String vehicleNumber, String model, Double capacityKg) {
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