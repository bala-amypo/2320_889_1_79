package com.example.demo.service.impl;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle createVehicle(VehicleDTO dto) {

        if (vehicleRepository.existsByVehicleNumber(dto.getVehicleNumber())) {
            throw new IllegalArgumentException("Vehicle number already exists");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(dto.getVehicleNumber());
        vehicle.setCapacityKg(dto.getCapacityKg());
        vehicle.setFuelEfficiency(dto.getFuelEfficiency());

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Long id) {

        return vehicleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found with id " + id)
                );
    }
}
