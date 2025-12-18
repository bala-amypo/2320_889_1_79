package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Shipment;

public interface ShipmentRepoepo
        extends JpaRepository<Shipment, Long> {
}