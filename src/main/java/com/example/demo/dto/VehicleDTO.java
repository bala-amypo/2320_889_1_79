package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VehicleDTO {

    private Long id;

    @NotBlank
    private String model;

    @NotBlank
    private String number;

    @NotNull
    private Double capacityKg;

    private Long userId;

    public VehicleDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Double getCapacityKg() { return capacityKg; }
    public void setCapacityKg(Double capacityKg) { this.capacityKg = capacityKg; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
