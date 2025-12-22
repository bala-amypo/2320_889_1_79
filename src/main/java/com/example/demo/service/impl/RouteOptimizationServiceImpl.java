package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Map<String, Object> optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        double distance = Math.sqrt(
                Math.pow(pickup.getLatitude() - drop.getLatitude(), 2) +
                Math.pow(pickup.getLongitude() - drop.getLongitude(), 2)
        ) * 111;

        double fuelUsage = distance / 10;

        shipment.setOptimizedDistanceKm(distance);
        shipment.setEstimatedFuelUsageL(fuelUsage);
        shipmentRepository.save(shipment);

        Map<String, Object> response = new HashMap<>();
        response.put("shipmentId", shipment.getId());
        response.put("optimizedDistanceKm", distance);
        response.put("estimatedFuelUsageL", fuelUsage);

        return response;
    }
}
