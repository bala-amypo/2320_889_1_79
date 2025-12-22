package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ShipmentDTO {

    private Long id;

    @NotNull(message = "Scheduled date is required")
    private LocalDate scheduledDate;

    @NotNull(message = "Weight is required")
    private Double weightKg;

    @NotNull(message = "Pickup location id is required")
    private Long pickupLocationId;

    @NotNull(message = "Drop location id is required")
    private Long dropLocationId;

    @NotNull(message = "Vehicle id is required")
    private Long vehicleId;

    public ShipmentDTO() {}

    public ShipmentDTO(Long id, LocalDate scheduledDate, Double weightKg,
                       Long pickupLocationId, Long dropLocationId, Long vehicleId) {
        this.id = id;
        this.scheduledDate = scheduledDate;
        this.weightKg = weightKg;
        this.pickupLocationId = pickupLocationId;
        this.dropLocationId = dropLocationId;
        this.vehicleId = vehicleId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public Long getPickupLocationId() { return pickupLocationId; }
    public void setPickupLocationId(Long pickupLocationId) { this.pickupLocationId = pickupLocationId; }

    public Long getDropLocationId() { return dropLocationId; }
    public void setDropLocationId(Long dropLocationId) { this.dropLocationId = dropLocationId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
}