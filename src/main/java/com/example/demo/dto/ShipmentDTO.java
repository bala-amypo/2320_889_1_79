package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ShipmentDTO {

    private Long id;

    @NotNull(message = "Pickup location is required")
    private Long pickupLocationId;

    @NotNull(message = "Drop location is required")
    private Long dropLocationId;

    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @NotNull(message = "Weight is required")
    private Double weightKg;

    @NotNull(message = "Scheduled date is required")
    private LocalDate scheduledDate;

    public ShipmentDTO() {}

    public ShipmentDTO(Long id, Long pickupLocationId, Long dropLocationId,
                       Long vehicleId, Double weightKg, LocalDate scheduledDate) {
        this.id = id;
        this.pickupLocationId = pickupLocationId;
        this.dropLocationId = dropLocationId;
        this.vehicleId = vehicleId;
        this.weightKg = weightKg;
        this.scheduledDate = scheduledDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPickupLocationId() { return pickupLocationId; }
    public void setPickupLocationId(Long pickupLocationId) { this.pickupLocationId = pickupLocationId; }

    public Long getDropLocationId() { return dropLocationId; }
    public void setDropLocationId(Long dropLocationId) { this.dropLocationId = dropLocationId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
}