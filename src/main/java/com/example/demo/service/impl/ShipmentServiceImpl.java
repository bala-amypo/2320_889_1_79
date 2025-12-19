package com.example.demo.service.impl;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public ShipmentDTO createShipment(ShipmentDTO dto) {

        Location pickup = locationRepository.findById(dto.getPickupLocationId())
                .orElseThrow(() -> new RuntimeException("Pickup location not found"));

        Location drop = locationRepository.findById(dto.getDropLocationId())
                .orElseThrow(() -> new RuntimeException("Drop location not found"));

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        Shipment shipment = new Shipment();
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);
        shipment.setVehicle(vehicle);
        shipment.setWeightKg(dto.getWeightKg());
        shipment.setScheduledDate(dto.getScheduledDate());

        Shipment saved = shipmentRepository.save(shipment);
        return mapToDTO(saved);
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ THIS METHOD WAS MISSING (ERROR FIX)
    @Override
    public ShipmentDTO getShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
        return mapToDTO(shipment);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    private ShipmentDTO mapToDTO(Shipment shipment) {
        ShipmentDTO dto = new ShipmentDTO();
        dto.setId(shipment.getId());
        dto.setPickupLocationId(shipment.getPickupLocation().getId());
        dto.setDropLocationId(shipment.getDropLocation().getId());
        dto.setVehicleId(shipment.getVehicle().getId());
        dto.setWeightKg(shipment.getWeightKg());
        dto.setScheduledDate(shipment.getScheduledDate());
        return dto;
    }
}
