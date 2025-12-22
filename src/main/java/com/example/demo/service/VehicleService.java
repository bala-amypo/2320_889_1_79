package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Vehicle;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    List<Vehicle> getAllVehicles();

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    void deleteVehicle(Long id);
}