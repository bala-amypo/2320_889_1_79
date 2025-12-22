package com.example.demo.service.impl;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
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

    private VehicleDTO mapToDTO(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getVehicleNumber(),
                vehicle.getModel(),
                vehicle.getCapacityKg()
        );
    }

    private Vehicle mapToEntity(VehicleDTO dto) {
        return new Vehicle(
                dto.getId(),
                dto.getVehicleNumber(),
                dto.getModel(),
                dto.getCapacityKg()
        );
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = mapToEntity(vehicleDTO);
        return mapToDTO(vehicleRepository.save(vehicle));
    }

    @Override
    public VehicleDTO getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + id));
        return mapToDTO(vehicle);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + id));

        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setCapacityKg(vehicleDTO.getCapacityKg());

        return mapToDTO(vehicleRepository.save(vehicle));
    }

    @Override
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehicle not found with id " + id);
        }
        vehicleRepository.deleteById(id);
    }
}