package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle);
    List<Vehicle> getVehiclesByUser(Long userId);
    Optional<Vehicle> findById(Long id);
}
