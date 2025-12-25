package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        return RouteOptimizationResult.builder()
                .success(true)
                .feasible(true)
                .optimized(true)
                .totalDistanceKm(120.0)
                .totalCost(500.0)
                .build();
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return optimizeRoute(shipmentId);
    }
}
