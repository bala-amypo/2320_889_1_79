package com.example.demo.controller;

import com.example.demo.dto.RouteOptimizationDTO;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService service;

    public RouteOptimizationController(RouteOptimizationService service) {
        this.service = service;
    }

    @PostMapping("/optimize/{shipmentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RouteOptimizationDTO optimize(@PathVariable Long shipmentId) {
        return service.optimizeRoute(shipmentId);
    }

    @GetMapping("/{shipmentId}")
    public RouteOptimizationDTO getResult(@PathVariable Long shipmentId) {
        return service.getResultByShipmentId(shipmentId);
    }
}