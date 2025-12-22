package com.example.demo.service;

import com.example.demo.dto.ShipmentDTO;

import java.util.List;

public interface ShipmentService {

    ShipmentDTO createShipment(ShipmentDTO shipmentDTO);

    ShipmentDTO getShipmentById(Long id);

    List<ShipmentDTO> getAllShipments();

    ShipmentDTO updateShipment(Long id, ShipmentDTO shipmentDTO);

    void deleteShipment(Long id);
}