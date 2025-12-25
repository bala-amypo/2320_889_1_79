package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    public RouteOptimizationResult(){
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId(){ return id;}
    public Shipment getShipment(){ return shipment;}
    public void setShipment(Shipment s){ this.shipment=s;}
    public Double getOptimizedDistanceKm(){ return optimizedDistanceKm;}
    public void setOptimizedDistanceKm(Double d){ this.optimizedDistanceKm=d;}
    public Double getEstimatedFuelUsageL(){ return estimatedFuelUsageL;}
    public void setEstimatedFuelUsageL(Double f){ this.estimatedFuelUsageL=f;}
    public LocalDateTime getGeneratedAt(){ return generatedAt;}
}
