package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "shipment_id", nullable = false)
    private Shipment shipment;
    
    @NotNull
    @Positive
    private Double optimizedDistanceKm;
    
    @NotNull
    @Positive
    private Double estimatedFuelUsageL;
    
    @NotNull
    private LocalDateTime generatedAt;
    
    public RouteOptimizationResult() {}
    
    public RouteOptimizationResult(Shipment shipment, Double optimizedDistanceKm, 
                                   Double estimatedFuelUsageL, LocalDateTime generatedAt) {
        this.shipment = shipment;
        this.optimizedDistanceKm = optimizedDistanceKm;
        this.estimatedFuelUsageL = estimatedFuelUsageL;
        this.generatedAt = generatedAt;
    }
    
    @PrePersist
    protected void onCreate() {
        if (generatedAt == null) {
            generatedAt = LocalDateTime.now();
        }
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Shipment getShipment() { return shipment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
    
    public Double getOptimizedDistanceKm() { return optimizedDistanceKm; }
    public void setOptimizedDistanceKm(Double optimizedDistanceKm) { 
        this.optimizedDistanceKm = optimizedDistanceKm; 
    }
    
    public Double getEstimatedFuelUsageL() { return estimatedFuelUsageL; }
    public void setEstimatedFuelUsageL(Double estimatedFuelUsageL) { 
        this.estimatedFuelUsageL = estimatedFuelUsageL; 
    }
    
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(LocalDateTime generatedAt) { this.generatedAt = generatedAt; }
}