package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize")
public class RouteOptimizationController {
    
    @Autowired
    private RouteOptimizationService routeOptimizationService;
    
    @PostMapping("/{shipmentId}")
    public ResponseEntity<RouteOptimizationResult> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResult result = routeOptimizationService.optimizeRoute(shipmentId);
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{resultId}")
    public ResponseEntity<RouteOptimizationResult> getResult(@PathVariable Long resultId) {
        return ResponseEntity.ok(routeOptimizationService.getResult(resultId));
    }
}