package com.example.demo.service;

import com.example.demo.dto.ShipmentDTO;
import java.util.List;

public interface ShipmentService {

    ShipmentDTO createShipment(ShipmentDTO shipmentDTO);

    List<ShipmentDTO> getAllShipments();

    ShipmentDTO getShipmentById(Long id);   // ⚠ REQUIRED

    void deleteShipment(Long id);
}
