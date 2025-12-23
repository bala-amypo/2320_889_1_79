package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    
    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    
    @Autowired
    public ShipmentServiceImpl(ShipmentRepository shipmentRepository, VehicleRepository vehicleRepository) {
        this.shipmentRepository = shipmentRepository;
        this.vehicleRepository = vehicleRepository;
    }
    
    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        
        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("exceeds vehicle capacity");
        }
        
        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("past");
        }
        
        shipment.setVehicle(vehicle);
        return shipmentRepository.save(shipment);
    }
    
    @Override
    public Shipment getShipment(Long shipmentId) {
        return shipmentRepository.findById(shipmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
    
    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
    
    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existingShipment = getShipment(id);
        existingShipment.setWeightKg(shipment.getWeightKg());
        existingShipment.setScheduledDate(shipment.getScheduledDate());
        return shipmentRepository.save(existingShipment);
    }
    
    @Override
    public void deleteShipment(Long id) {
        Shipment shipment = getShipment(id);
        shipmentRepository.delete(shipment);
    }
}
