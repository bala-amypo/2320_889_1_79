package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

        Optional<Shipment> optionalShipment = shipmentRepository.findById(shipmentId);

        if (optionalShipment.isEmpty()) {
            return false;
        }

        Shipment shipment = optionalShipment.get();

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
        return resultRepository.findByShipmentId(shipmentId).orElse(null);
    }
}
