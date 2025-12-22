package com.example.demo.service.impl;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.entity.Location;
import com.example.demo.entity.Shipment;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
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

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository,
                               LocationRepository locationRepository,
                               VehicleRepository vehicleRepository) {
        this.shipmentRepository = shipmentRepository;
        this.locationRepository = locationRepository;
        this.vehicleRepository = vehicleRepository;
    }

    private ShipmentDTO mapToDTO(Shipment shipment) {
        return new ShipmentDTO(
                shipment.getId(),
                shipment.getScheduledDate(),
                shipment.getWeightKg(),
                shipment.getPickupLocation().getId(),
                shipment.getDropLocation().getId(),
                shipment.getVehicle().getId()
        );
    }

    @Override
    public ShipmentDTO createShipment(ShipmentDTO dto) {

        Location pickup = locationRepository.findById(dto.getPickupLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Pickup location not found"));

        Location drop = locationRepository.findById(dto.getDropLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Drop location not found"));

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        Shipment shipment = new Shipment();
        shipment.setScheduledDate(dto.getScheduledDate());
        shipment.setWeightKg(dto.getWeightKg());
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);
        shipment.setVehicle(vehicle);

        return mapToDTO(shipmentRepository.save(shipment));
    }

    @Override
    public ShipmentDTO getShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found with id " + id));
        return mapToDTO(shipment);
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        return shipmentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShipmentDTO updateShipment(Long id, ShipmentDTO dto) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        Location pickup = locationRepository.findById(dto.getPickupLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Pickup location not found"));

        Location drop = locationRepository.findById(dto.getDropLocationId())
                .orElseThrow(() -> new ResourceNotFoundException("Drop location not found"));

        Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        shipment.setScheduledDate(dto.getScheduledDate());
        shipment.setWeightKg(dto.getWeightKg());
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);
        shipment.setVehicle(vehicle);

        return mapToDTO(shipmentRepository.save(shipment));
    }

    @Override
    public void deleteShipment(Long id) {
        if (!shipmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Shipment not found with id " + id);
        }
        shipmentRepository.deleteById(id);
    }
}