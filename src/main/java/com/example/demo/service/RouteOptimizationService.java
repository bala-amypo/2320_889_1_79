package com.example.demo.service;

import com.example.demo.dto.RouteOptimizationDTO;

public interface RouteOptimizationService {

    RouteOptimizationDTO optimizeRoute(Long shipmentId);

    RouteOptimizationDTO getResultByShipmentId(Long shipmentId);
}