package com.example.demo.controller;

import com.example.demo.dto.VehicleDTO;
import com.example.demo.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO createVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.createVehicle(vehicleDTO);
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    public List<VehicleDTO> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{id}")
    public VehicleDTO updateVehicle(@PathVariable Long id,
                                    @Valid @RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.updateVehicle(id, vehicleDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}