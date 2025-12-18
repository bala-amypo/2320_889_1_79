package com.example.demo.service.impl;

import com.example.demo.entity.Vehicle;
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
    public Vehicle saveVehicle(Vehicle vehicle) {

        // ✅ CORRECT VALIDATION
        if (vehicle.getCapacityKg() <= 0) {
            throw new RuntimeException("Vehicle capacity must be greater than 0");
        }

        return vehicleRepository.save(vehicle);
    }
}
