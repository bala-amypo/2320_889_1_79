package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository,
                                        RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double lat1 = shipment.getPickupLocation().getLatitude();
        double lon1 = shipment.getPickupLocation().getLongitude();
        double lat2 = shipment.getDropLocation().getLatitude();
        double lon2 = shipment.getDropLocation().getLongitude();

        double distance = Math.hypot(lat2 - lat1, lon2 - lon1) * 111;
        if (distance <= 0) distance = 1;

        double fuel = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(fuel)
                .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
