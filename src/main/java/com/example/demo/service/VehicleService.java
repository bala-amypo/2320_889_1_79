package com.example.demo.service;

import com.example.demo.dto.VehicleDTO;
import java.util.List;

public interface VehicleService {

    VehicleDTO createVehicle(VehicleDTO dto);

    VehicleDTO getVehicleById(Long id);

    List<VehicleDTO> getAllVehicles();

    void deleteVehicle(Long id);
}
