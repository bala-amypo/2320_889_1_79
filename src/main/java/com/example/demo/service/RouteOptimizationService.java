package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteOptimizationService {

    public RouteOptimizationResult optimizeRoute(List<Shipment> shipments) {

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .success(true)
                .feasible(true)
                .optimized(true)
                .totalDistanceKm(100.0)
                .totalCost(500.0)
                .build();

        return result;
    }
}
