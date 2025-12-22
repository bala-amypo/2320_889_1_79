package com.example.demo.service;

import com.example.demo.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    VehicleDTO getVehicleById(Long id);

    List<VehicleDTO> getAllVehicles();

    VehicleDTO updateVehicle(Long id, VehicleDTO vehicleDTO);

    void deleteVehicle(Long id);
}