package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.RouteOptimizationService;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository s,
                                        RouteOptimizationResultRepository r){
        this.shipRepo = s;
        this.resultRepo = r;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId){

        Shipment s = shipRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                s.getDropLocation().getLatitude() - s.getPickupLocation().getLatitude(),
                s.getDropLocation().getLongitude() - s.getPickupLocation().getLongitude()
        ) * 100;

        double fuel = distance / s.getVehicle().getFuelEfficiency();

        RouteOptimizationResult r = RouteOptimizationResult.builder()
                .shipment(s)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(fuel)
                .build();

        return resultRepo.save(r);
    }

    @Override
    public RouteOptimizationResult getResult(Long id){
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
