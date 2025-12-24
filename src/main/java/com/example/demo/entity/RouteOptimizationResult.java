package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

    // 🔹 REQUIRED BY JPA
    public RouteOptimizationResult() {
    }

    // 🔹 REQUIRED BY SERVICE & TESTS
    public RouteOptimizationResult(
            Shipment shipment,
            Double optimizedDistanceKm,
            Double estimatedFuelUsageL,
            LocalDateTime generatedAt
    ) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }

    // 🔹 OPTIONAL (keep if already used)
    public RouteOptimizationResult(
            Long id,
            Shipment shipment,
            Double optimizedDistanceKm,
            Double estimatedFuelUsageL,
            LocalDateTime generatedAt
    ) {
        this.id = id;
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }

    // Getters & setters
    public Long getId() { return id; }
    public Shipment getShipment() { return shipment; }
    public Double getOptimizedDistanceKm() { return optimizedDistanceKm; }
    public Double getEstimatedFuelUsageL() { return estimatedFuelUsageL; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
    public void setOptimizedDistanceKm(Double optimizedDistanceKm) { this.optimizedDistanceKm = optimizedDistanceKm; }
    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) { this.estimatedFuelUsageL = estimatedFuelUsageL; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}
