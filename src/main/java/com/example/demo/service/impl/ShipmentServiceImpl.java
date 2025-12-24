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

    @Override
    public Shipment createShipment(Long vehicleId, Shipment s) {
        Vehicle v = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (s.getWeightKg() > v.getCapacityKg())
            throw new IllegalArgumentException("Weight exceeds capacity");

        if (s.getScheduledDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Scheduled date in past");

        s.setVehicle(v);
        s.setPickupLocation(locationRepo.findById(s.getPickupLocation().getId()).get());
        s.setDropLocation(locationRepo.findById(s.getDropLocation().getId()).get());

        return shipmentRepo.save(s);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
