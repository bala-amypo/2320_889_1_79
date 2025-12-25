package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service){
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Vehicle add(@PathVariable Long userId, @RequestBody Vehicle v){
        return service.addVehicle(userId, v);
    }

    @GetMapping("/{userId}")
    public List<Vehicle> list(@PathVariable Long userId){
        return service.getVehiclesByUser(userId);
    }
}
