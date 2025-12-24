package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
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
    public boolean optimizeRoute(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElse(null);

        if (shipment == null) {
            return false;
        }

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setTotalDistance(120.0);
        result.setEstimatedTime(2.5);
        result.setGeneratedAt(LocalDateTime.now());

        resultRepository.save(result);
        return true;
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return resultRepository.findByShipmentId(shipmentId)
                .orElseThrow(() -> new RuntimeException("Result Not Found"));
    }
}
