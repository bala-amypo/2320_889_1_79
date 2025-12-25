package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;          // <-- REQUIRED FOR BUILDER .shipment()

    private double optimizedDistanceKm;

    private double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    @PrePersist
    public void setGeneratedTime() {
        if (generatedAt == null)
            generatedAt = LocalDateTime.now();
    }
}
