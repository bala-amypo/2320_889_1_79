package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ShipmentService {
    
    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;
    
    @Autowired
    public ShipmentService(ShipmentRepository shipmentRepository, 
                          VehicleRepository vehicleRepository,
                          LocationRepository locationRepository) {
        this.shipmentRepository = shipmentRepository;
        this.vehicleRepository = vehicleRepository;
        this.locationRepository = locationRepository;
    }
    
    public Shipment createShipment(Long vehicleId, Shipment shipment) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        
        // Validate vehicle capacity
        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("exceeds vehicle capacity");
        }
        
        // Validate scheduled date is not in the past
        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("past");
        }
        
        shipment.setVehicle(vehicle);
        return shipmentRepository.save(shipment);
    }
    
    public Shipment getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}