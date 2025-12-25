package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteOptimizationResult {

    private Boolean success;
    private Boolean feasible;
    private Boolean optimized;

    private double totalDistanceKm;
    private double totalCost;
}
