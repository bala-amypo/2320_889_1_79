package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepository,
            RouteOptimizationResultRepository resultRepository
    ) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        double distance = Math.hypot(
                pickup.getLatitude() - drop.getLatitude(),
                pickup.getLongitude() - drop.getLongitude()
        );

        if (distance <= 0) {
            distance = 1.0;
        }

        double fuelUsage = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result = new RouteOptimizationResult(
                shipment,
                distance,
                fuelUsage,
                LocalDateTime.now()
        );

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
