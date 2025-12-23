package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {
    
    private final RouteOptimizationResultRepository routeRepository;
    private final ShipmentRepository shipmentRepository;
    
    @Autowired
    public RouteOptimizationServiceImpl(RouteOptimizationResultRepository routeRepository,
                                       ShipmentRepository shipmentRepository) {
        this.routeRepository = routeRepository;
        this.shipmentRepository = shipmentRepository;
    }
    
    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        
        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();
        
        double distance = calculateDistance(
            pickup.getLatitude(), pickup.getLongitude(),
            drop.getLatitude(), drop.getLongitude()
        );
        
        double fuelUsage = distance / shipment.getVehicle().getFuelEfficiency();
        
        RouteOptimizationResult result = new RouteOptimizationResult(
            shipment, distance, fuelUsage
        );
        
        return routeRepository.save(result);
    }
    
    @Override
    public RouteOptimizationResult getResult(Long resultId) {
        return routeRepository.findById(resultId)
            .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
    
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371;
        
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        
        return R * c;
    }
}