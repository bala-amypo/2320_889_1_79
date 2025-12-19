package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class VehicleDTO {

    private Long id;

    @NotBlank(message = "Vehicle number is required")
    private String number;

    @NotBlank(message = "Vehicle model is required")
    private String model;

    @NotNull(message = "Capacity is required")
    @Positive(message = "Capacity must be greater than zero")
    private Double capacityKg;

    public VehicleDTO() {}

    public VehicleDTO(Long id, String number, String model, Double capacityKg) {
        this.id = id;
        this.number = number;
        this.model = model;
        this.capacityKg = capacityKg;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }

    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }
}
