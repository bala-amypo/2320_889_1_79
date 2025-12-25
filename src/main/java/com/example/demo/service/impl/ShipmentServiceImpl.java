package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository repo) {
        this.shipmentRepository = repo;
    }

    @Override
    public Shipment createShipment(long userId, Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
