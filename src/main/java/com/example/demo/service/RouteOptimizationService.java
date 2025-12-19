package com.example.demo.service;

import com.example.demo.dto.RouteOptimizationResultDTO;

public interface RouteOptimizationService {
    RouteOptimizationResultDTO optimizeRoute(Long shipmentId);
}
