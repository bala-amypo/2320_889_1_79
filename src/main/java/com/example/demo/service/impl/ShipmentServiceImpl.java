package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final LocationRepository locationRepository;
    private final VehicleRepository vehicleRepository;

    public ShipmentServiceImpl(
            ShipmentRepository shipmentRepository,
            LocationRepository locationRepository,
            VehicleRepository vehicleRepository) {

        this.shipmentRepository = shipmentRepository;
        this.locationRepository = locationRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment optimizeShipment(Long shipmentId, Long vehicleId) {

        Shipment shipment = getShipmentById(shipmentId);
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Location pickup = shipment.getPickupLocation();
        Location drop = shipment.getDropLocation();

        // Simple distance formula
        double distance = Math.sqrt(
                Math.pow(pickup.getLatitude() - drop.getLatitude(), 2) +
                Math.pow(pickup.getLongitude() - drop.getLongitude(), 2)
        ) * 111;

        shipment.setOptimizedDistanceKm(distance);
        shipment.setEstimatedFuelUsageL(distance / 10);
        shipment.setVehicle(vehicle);

        return shipmentRepository.save(shipment);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
