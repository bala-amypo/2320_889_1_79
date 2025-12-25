package com.example.demo.service;

import com.example.demo.entity.Shipment;

public interface ShipmentService {

    Shipment createShipment(long userId, Shipment shipment);

    Shipment create(Shipment shipment);

    Shipment getShipment(Long id);
}
