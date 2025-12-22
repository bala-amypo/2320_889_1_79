package com.example.demo.service;

import com.example.demo.entity.Vehicle;
import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    void deleteVehicle(Long id);
}
