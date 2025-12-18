package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Vehicle;

public interface VehicleRepoepo
        extends JpaRepository<Vehicle, Long> {
}