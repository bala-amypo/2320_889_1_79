package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService service;

    public RouteOptimizationController(RouteOptimizationService service){
        this.service = service;
    }

    @PostMapping("/{shipmentId}")
    public boolean optimize(@PathVariable Long shipmentId){
        return service.optimizeRoute(shipmentId);
    }

    @GetMapping("/{id}")
    public RouteOptimizationResult get(@PathVariable Long id){
        return service.getResult(id);
    }
}
