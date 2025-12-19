package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;

public class RouteOptimizationResultDTO {

    private Long id;

    @Positive(message = "Optimized distance must be positive")
    private Double optimizedDistanceKm;

    @Positive(message = "Estimated fuel usage must be positive")
    private Double estimatedFuelUsageL;

    @NotNull(message = "Generated time is required")
    private LocalDateTime generatedAt;

    public RouteOptimizationResultDTO() {}

    public RouteOptimizationResultDTO(
            Long id,
            Double optimizedDistanceKm,
            Double estimatedFuelUsageL,
            LocalDateTime generatedAt) {
        this.id = id;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getOptimizedDistanceKm() {
        return optimizedDistanceKm;
    }

    public void setOptimizedDistanceKm(Double optimizedDistanceKm) {
        this.optimizedDistanceKm = optimizedDistanceKm;
    }

    public Double getEstimatedFuelUsageL() {
        return estimatedFuelUsageL;
    }

    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) {
        this.estimatedFuelUsageL = estimatedFuelUsageL;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
}
