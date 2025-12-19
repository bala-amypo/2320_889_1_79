package com.example.demo.service.impl;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(dto.getVehicleNumber());
        vehicle.setFuelEfficiency(dto.getFuelEfficiency());
        vehicle.setCapacityKg(dto.getCapacityKg());

        Vehicle saved = vehicleRepository.save(vehicle);
        return mapToDTO(saved);
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    private VehicleDTO mapToDTO(Vehicle vehicle) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(vehicle.getId());
        dto.setVehicleNumber(vehicle.getVehicleNumber());
        dto.setFuelEfficiency(vehicle.getFuelEfficiency());
        dto.setCapacityKg(vehicle.getCapacityKg());
        return dto;
    }
}
