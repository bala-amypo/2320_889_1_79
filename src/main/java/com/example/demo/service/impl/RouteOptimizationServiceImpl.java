package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(
            ShipmentRepository shipmentRepo,
            RouteOptimizationResultRepository resultRepo
    ){
        this.shipmentRepo = shipmentRepo;
        this.resultRepo = resultRepo;
    }

    public boolean optimizeRoute(Long shipmentId){

        Shipment shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment Not Found"));

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(120.0);
        result.setEstimatedFuelUsageL(40.0);

        resultRepo.save(result);
        return true;
    }

    public RouteOptimizationResult getResult(Long id){
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result Not Found"));
    }
}
