package com.example.demo.service;

import com.example.demo.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    Vehicle save(Vehicle vehicle);

    List<Vehicle> getAll();

    Optional<Vehicle> findById(long id);

}
