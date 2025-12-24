package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ApiResponse> addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        Vehicle saved = vehicleService.addVehicle(userId, vehicle);
        return ResponseEntity.ok(new ApiResponse(true, "Vehicle added", saved));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUser(userId));
    }
}