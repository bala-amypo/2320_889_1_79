package com.example.demo.service;

import com.example.demo.dto.ShipmentDTO;
import java.util.List;

public interface ShipmentService {

    ShipmentDTO createShipment(ShipmentDTO dto);
    ShipmentDTO getShipmentById(Long id);
    List<ShipmentDTO> getAllShipments();
}
