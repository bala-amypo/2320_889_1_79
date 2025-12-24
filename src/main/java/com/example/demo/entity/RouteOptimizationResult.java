package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "route_optimization_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;

    private LocalDateTime generatedAt;

    @PrePersist
    public void prePersist() {
        generatedAt = LocalDateTime.now();
    }
}
