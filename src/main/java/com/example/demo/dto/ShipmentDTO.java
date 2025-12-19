package com.example.demo.dto;

import java.time.LocalDate;

public class ShipmentDTO {

    private Long id;
    private Long pickupLocationId;
    private Long dropLocationId;
    private Long vehicleId;
    private Double weightKg;
    private LocalDate scheduledDate;

    public ShipmentDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPickupLocationId() {
        return pickupLocationId;
    }

    public void setPickupLocationId(Long pickupLocationId) {
        this.pickupLocationId = pickupLocationId;
    }

    public Long getDropLocationId() {
        return dropLocationId;
    }

    public void setDropLocationId(Long dropLocationId) {
        this.dropLocationId = dropLocationId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
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

