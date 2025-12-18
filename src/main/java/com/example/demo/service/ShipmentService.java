package com.example.demo.service;

import com.example.demo.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment addShipment(Shipment shipment);

    List<Shipment> getAllShipments();

    Shipment findById(Long shipmentId);
}
