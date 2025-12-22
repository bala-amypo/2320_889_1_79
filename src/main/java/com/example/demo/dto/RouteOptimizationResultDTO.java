package com.example.demo.dto;

import java.time.LocalDateTime;

public class RouteOptimizationDTO {

    private Long id;
    private Long shipmentId;
    private Double optimizedDistanceKm;
    private Double estimatedFuelUsage;
    private LocalDateTime generatedAt;

    public RouteOptimizationDTO() {}

    public RouteOptimizationDTO(Long id, Long shipmentId,
                                Double optimizedDistanceKm,
                                Double estimatedFuelUsage,
                                LocalDateTime generatedAt) {
        this.id = id;
        this.shipmentId = shipmentId;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsage = estimatedFuelUsage;
        this.generatedAt = generatedAt;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Double getOptimizedDistanceKm() { return optimizedDistanceKm; }
    public void setOptimizedDistanceKm(Double optimizedDistanceKm) {
        this.optimizedDistanceKm = optimizedDistanceKm;
    }

    public Double getEstimatedFuelUsage() { return estimatedFuelUsage; }
    public void setEstimatedFuelUsage(Double estimatedFuelUsage) {
        this.estimatedFuelUsage = estimatedFuelUsage;
    }

    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}