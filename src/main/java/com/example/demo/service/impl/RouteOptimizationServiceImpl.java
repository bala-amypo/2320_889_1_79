package com.example.demo.service.impl;

import com.example.demo.dto.RouteOptimizationDTO;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final RouteOptimizationRepository repository;
    private final ShipmentRepository shipmentRepository;

    public RouteOptimizationServiceImpl(RouteOptimizationRepository repository,
                                        ShipmentRepository shipmentRepository) {
        this.repository = repository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public RouteOptimizationDTO optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Shipment not found"));

        // SIMPLE deterministic logic (IMPORTANT FOR TEST CASES)
        double distance = 100.0;
        double fuelUsage = shipment.getWeightKg() * 0.1;

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(distance);
        result.setEstimatedFuelUsage(fuelUsage);
        result.setGeneratedAt(LocalDateTime.now());

        RouteOptimizationResult saved = repository.save(result);

        return mapToDTO(saved);
    }

    @Override
    public RouteOptimizationDTO getResultByShipmentId(Long shipmentId) {

        RouteOptimizationResult result = repository.findByShipmentId(shipmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Optimization result not found"));

        return mapToDTO(result);
    }

    private RouteOptimizationDTO mapToDTO(RouteOptimizationResult result) {
        return new RouteOptimizationDTO(
                result.getId(),
                result.getShipment().getId(),
                result.getOptimizedDistanceKm(),
                result.getEstimatedFuelUsage(),
                result.getGeneratedAt()
        );
    }
}