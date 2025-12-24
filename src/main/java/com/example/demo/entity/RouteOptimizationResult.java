package com.example.demo.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RouteOptimizationResult {
    private Long id;
    private Shipment shipment;
    private double optimizedDistanceKm;
    private double estimatedFuelUsageL;
    private LocalDateTime generatedAt;
}
