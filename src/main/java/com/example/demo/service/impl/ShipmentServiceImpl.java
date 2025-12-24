package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ShipmentService;

import java.time.LocalDate;

public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;
    private final LocationRepository locationRepo;

    public ShipmentServiceImpl(ShipmentRepository s, VehicleRepository v, LocationRepository l) {
        this.shipmentRepo = s;
        this.vehicleRepo = v;
        this.locationRepo = l;
    }

    public Shipment createShipment(Long vehicleId, Shipment s) {

        if (s.getScheduledDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Scheduled date is in the past");

        Vehicle v = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (s.getWeightKg() > v.getCapacityKg())
            throw new IllegalArgumentException("Weight exceeds capacity");

        Location p = locationRepo.findById(s.getPickupLocation().getId()).orElseThrow();
        Location d = locationRepo.findById(s.getDropLocation().getId()).orElseThrow();

        s.setVehicle(v);
        s.setPickupLocation(p);
        s.setDropLocation(d);

        return shipmentRepo.save(s);
    }

    public Shipment getShipment(Long id) {
        return shipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
