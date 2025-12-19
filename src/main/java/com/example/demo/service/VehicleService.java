package com.example.demo.service;

import com.example.demo.dto.VehicleDTO;
import java.util.List;

public interface VehicleService {
    VehicleDTO createVehicle(VehicleDTO dto);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO getVehicleById(Long id);
}
