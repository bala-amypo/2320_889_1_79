package com.example.demo.repository;

import com.example.demo.entity.RouteOptimizationResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteOptimizationResultRepository
        extends JpaRepository<RouteOptimizationResult, Long> {

    Optional<RouteOptimizationResult> findByShipmentId(Long shipmentId);
}
