package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;

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

        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (s.getWeightKg() > vehicle.getCapacityKg())
            throw new IllegalArgumentException("exceeds");

        if (s.getScheduledDate().isBefore(java.time.LocalDate.now()))
            throw new IllegalArgumentException("past");

        Location pickup = locationRepo.findById(s.getPickupLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        Location drop = locationRepo.findById(s.getDropLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        s.setVehicle(vehicle);
        s.setPickupLocation(pickup);
        s.setDropLocation(drop);

        return shipmentRepo.save(s);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
