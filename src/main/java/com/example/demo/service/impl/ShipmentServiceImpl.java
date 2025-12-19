package com.example.demo.service.impl;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repo;

    public ShipmentServiceImpl(ShipmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public ShipmentDTO createShipment(ShipmentDTO dto) {
        Shipment s = new Shipment();
        s.setWeightKg(dto.getWeightKg());
        s.setScheduledDate(dto.getScheduledDate());

        Shipment saved = repo.save(s);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public ShipmentDTO getShipmentById(Long id) {
        Shipment s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
        return mapToDTO(s);
    }

    @Override
    public List<ShipmentDTO> getAllShipments() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private ShipmentDTO mapToDTO(Shipment s) {
        ShipmentDTO dto = new ShipmentDTO();
        dto.setId(s.getId());
        dto.setWeightKg(s.getWeightKg());
        dto.setScheduledDate(s.getScheduledDate());
        return dto;
    }
    Location pickup = locationRepository.findById(dto.getPickupLocationId())
        .orElseThrow(() -> new ResourceNotFoundException("Pickup location not found"));

Location drop = locationRepository.findById(dto.getDropLocationId())
        .orElseThrow(() -> new ResourceNotFoundException("Drop location not found"));

Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

}
