package com.example.demo.service.impl;

import com.example.demo.dto.RouteOptimizationResultDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepo,
            RouteOptimizationResultRepository resultRepo) {
        this.shipmentRepo = shipmentRepo;
        this.resultRepo = resultRepo;
    }

    @Override
    public RouteOptimizationResultDTO optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(120.5);
        result.setEstimatedFuelUsageL(18.2);
        result.setGeneratedAt(LocalDateTime.now());

        RouteOptimizationResult saved = resultRepo.save(result);

        RouteOptimizationResultDTO dto = new RouteOptimizationResultDTO();
        dto.setId(saved.getId());
        dto.setOptimizedDistanceKm(saved.getOptimizedDistanceKm());
        dto.setEstimatedFuelUsageL(saved.getEstimatedFuelUsageL());
        dto.setGeneratedAt(saved.getGeneratedAt());

        return dto;
    }
}
