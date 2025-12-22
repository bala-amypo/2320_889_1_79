package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        double distance = Math.sqrt(
                Math.pow(pickup.getLatitude() - drop.getLatitude(), 2) +
                Math.pow(pickup.getLongitude() - drop.getLongitude(), 2)
        ) * 111;

        shipment.setOptimizedDistanceKm(distance);
        shipment.setEstimatedFuelUsageL(distance / 10);

        return shipmentRepository.save(shipment);
    }
}
