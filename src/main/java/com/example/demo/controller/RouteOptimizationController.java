package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/optimize")
public class RouteOptimizationController {

    private final RouteOptimizationService routeOptimizationService;

    // Constructor Injection ONLY
    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    @PostMapping("/{shipmentId}")
    public RouteOptimizationResult optimize(@PathVariable Long shipmentId) {
        return routeOptimizationService.optimizeRoute(shipmentId);
    }

    @GetMapping("/result/{resultId}")
    public RouteOptimizationResult getResult(@PathVariable Long resultId) {
        return routeOptimizationService.getResult(resultId);
    }
}