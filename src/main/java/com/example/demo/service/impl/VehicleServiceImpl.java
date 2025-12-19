package com.example.demo.service.impl;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;

    public VehicleServiceImpl(VehicleRepository repo) {
        this.repo = repo;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO dto) {
        Vehicle v = new Vehicle();
        v.setNumber(dto.getNumber());
        v.setModel(dto.getModel());
        v.setCapacityKg(dto.getCapacityKg());

        Vehicle saved = repo.save(v);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Vehicle v = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        return mapToDTO(v);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private VehicleDTO mapToDTO(Vehicle v) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(v.getId());
        dto.setNumber(v.getNumber());
        dto.setModel(v.getModel());
        dto.setCapacityKg(v.getCapacityKg());
        return dto;
    }
}
