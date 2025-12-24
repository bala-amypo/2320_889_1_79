package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="route_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalDistance;
    private double estimatedTime;
    private LocalDateTime generatedAt;

    @OneToOne
    private Shipment shipment;

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}

    public double getTotalDistance(){ return totalDistance;}
    public void setTotalDistance(double totalDistance){ this.totalDistance=totalDistance;}

    public double getEstimatedTime(){ return estimatedTime;}
    public void setEstimatedTime(double estimatedTime){ this.estimatedTime=estimatedTime;}

    public LocalDateTime getGeneratedAt(){ return generatedAt;}
    public void setGeneratedAt(LocalDateTime generatedAt){ this.generatedAt=generatedAt;}

    public Shipment getShipment(){ return shipment;}
    public void setShipment(Shipment shipment){ this.shipment=shipment;}
}
