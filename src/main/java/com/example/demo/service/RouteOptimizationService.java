package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

public interface RouteOptimizationService {
    boolean optimizeRoute(Long shipmentId);
    RouteOptimizationResult getResult(Long id);
}
