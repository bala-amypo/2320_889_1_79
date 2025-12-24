package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository s, RouteOptimizationResultRepository r) {
        this.shipmentRepo = s;
        this.resultRepo = r;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double dist = Math.hypot(
                shipment.getPickupLocation().getLatitude() - shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() - shipment.getDropLocation().getLongitude()
        );

        double fuel = dist / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult r = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(dist)
                .estimatedFuelUsageL(fuel)
                .build();

        return resultRepo.save(r);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
