package com.example.demo.service;

import com.example.demo.entity.Shipment;

public interface ShipmentService {
    Shipment createShipment(Long vehicleId, Shipment s);
    Shipment getShipment(Long id);
}
