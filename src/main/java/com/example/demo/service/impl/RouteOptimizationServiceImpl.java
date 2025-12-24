package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
                .orElseThrow(() -> new RuntimeException("Shipment Not Found"));

        RouteOptimizationResult result =
                resultRepository.findByShipmentId(shipmentId)
                        .orElse(new RouteOptimizationResult());

        result.setShipment(shipment);
        result.setTotalDistance(120.0);
        result.setEstimatedTime(2.5);
        result.setGeneratedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return resultRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new RuntimeException("Result Not Found"));
    }
}
