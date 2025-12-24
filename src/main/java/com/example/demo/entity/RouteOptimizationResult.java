package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TEST EXPECTS THESE FIELDS
    private double totalDistance;
    private double estimatedTime;

    private LocalDateTime generatedAt;

    @OneToOne
    @JoinColumn(name = "shipment_id")
    private Shipment shipment;
}
