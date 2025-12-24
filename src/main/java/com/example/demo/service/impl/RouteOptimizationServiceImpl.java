package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    @Autowired
    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepository,
                                        RouteOptimizationResultRepository resultRepository) {
        this.shipmentRepository = shipmentRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {

        Optional<Shipment> shipmentOpt = shipmentRepository.findById(shipmentId);
        if (shipmentOpt.isEmpty()) {
            return null;
        }

        Shipment shipment = shipmentOpt.get();

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        if (pickup == null || drop == null) {
            return null;
        }

        double distance = calculateDistance(
                pickup.getLatitude(), pickup.getLongitude(),
                drop.getLatitude(), drop.getLongitude()
        );

        double estimatedTime = distance / 40.0; // assume avg 40km/h

        RouteOptimizationResult result = new RouteOptimizationResult();
        result.setShipment(shipment);
        result.setTotalDistance(distance);
        result.setEstimatedTime(estimatedTime);
        result.setGeneratedAt(LocalDateTime.now());

        resultRepository.save(result);
        return result;
    }

    @Override
    public RouteOptimizationResult getResult(Long shipmentId) {
        return resultRepository.findByShipmentId(shipmentId).orElse(null);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371.0;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2)
                        + Math.cos(lat1) * Math.cos(lat2)
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }
}
