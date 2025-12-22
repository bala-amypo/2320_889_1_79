package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double optimizedDistanceKm;

    private Double estimatedFuelUsage;

    private LocalDateTime generatedAt;

    @OneToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;

    public RouteOptimizationResult() {}

    public RouteOptimizationResult(Long id, Double optimizedDistanceKm,
                                   Double estimatedFuelUsage,
                                   LocalDateTime generatedAt,
                                   Shipment shipment) {
        this.id = id;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsage = estimatedFuelUsage;
        this.generatedAt = generatedAt;
        this.shipment = shipment;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public Shipment getShipment() { return shipment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
}