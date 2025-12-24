package com.example.demo.repository;

import com.example.demo.entity.Vehicle;
import java.util.*;

public interface VehicleRepository {
    Vehicle save(Vehicle v);
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByUserId(Long userId);
    Optional<Vehicle> findByVehicleNumber(String number);
}
