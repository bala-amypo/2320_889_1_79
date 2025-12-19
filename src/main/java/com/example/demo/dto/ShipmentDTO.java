package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

public class ShipmentDTO {

    private Long id;

    @NotNull(message = "Shipment weight is required")
    @Positive(message = "Shipment weight must be greater than zero")
    private Double weightKg;

    @NotNull(message = "Scheduled date is required")
    private LocalDate scheduledDate;

    public ShipmentDTO() {}

    public ShipmentDTO(Long id, Double weightKg, LocalDate scheduledDate) {
        this.id = id;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}
