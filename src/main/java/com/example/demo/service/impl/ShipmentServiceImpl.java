package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repo;

    public ShipmentServiceImpl(ShipmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Shipment create(Shipment shipment) {
        return repo.save(shipment);
    }

    @Override
    public Shipment getShipment(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }
}
