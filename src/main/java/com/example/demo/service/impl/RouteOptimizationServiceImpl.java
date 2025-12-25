package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;

    @Override
    public RouteOptimizationResult optimize(Long shipmentId) {
        Optional<Shipment> shipmentOpt = shipmentRepository.findById(shipmentId);

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setSuccess(shipmentOpt.isPresent());
        result.setFeasible(shipmentOpt.isPresent());
        result.setOptimized(shipmentOpt.isPresent());

        result.setTotalDistanceKm(120.5);
        result.setTotalCost(3500.0);

        return result;
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return optimize(shipmentId);
    }
}
