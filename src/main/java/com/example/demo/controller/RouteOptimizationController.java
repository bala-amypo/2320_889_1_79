package com.example.demo.controller;

import com.example.demo.dto.RouteOptimizationResultDTO;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/route-optimization")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/{shipmentId}")
    public ResponseEntity<RouteOptimizationResultDTO> optimize(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(routeOptimizationService.optimizeRoute(shipmentId));
    }
}