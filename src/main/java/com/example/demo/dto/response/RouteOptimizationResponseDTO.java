package com.example.demo.dto.response;

import java.time.LocalDateTime;

public class RouteOptimizationResponseDTO {

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsage;
    private LocalDateTime generatedAt;

    public Double getOptimizedDistanceKm() {
        return optimizedDistanceKm;
    }

    public void setOptimizedDistanceKm(Double optimizedDistanceKm) {
        this.optimizedDistanceKm = optimizedDistanceKm;
    }

    public Double getEstimatedFuelUsage() {
        return estimatedFuelUsage;
    }

    public void setEstimatedFuelUsage(Double estimatedFuelUsage) {
        this.estimatedFuelUsage = estimatedFuelUsage;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
