package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/optimize")
public class RouteOptimizationController {
    
    private final RouteOptimizationService routeOptimizationService;
    
    public RouteOptimizationController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }
    
    @PostMapping("/{shipmentId}")
    public ResponseEntity<?> optimizeRoute(@PathVariable Long shipmentId) {
        try {
            RouteOptimizationResult result = routeOptimizationService.optimizeRoute(shipmentId);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/result/{resultId}")
    public ResponseEntity<?> getResult(@PathVariable Long resultId) {
        try {
            RouteOptimizationResult result = routeOptimizationService.getResult(resultId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}