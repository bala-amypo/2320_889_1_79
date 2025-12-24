package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

public interface RouteOptimizationService {

    Boolean optimizeRoute(Long shipmentId);

    RouteOptimizationResult getResult(Long shipmentId);
}
