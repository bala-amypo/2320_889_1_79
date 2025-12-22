package com.example.demo.service;

import com.example.demo.entity.Shipment;
import java.util.List;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    Shipment updateShipment(Long id, Shipment shipment);

    Shipment getShipmentById(Long id);

    List<Shipment> getAllShipments();

    void deleteShipment(Long id);
}
