package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;

public interface RouteOptimizationService {

    boolean optimizeRoute(Long shipmentId);   // must return boolean

    RouteOptimizationResult getResult(Long shipmentId);
}
