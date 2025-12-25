package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repo;

    public ShipmentServiceImpl(ShipmentRepository repo){
        this.repo = repo;
    }

    public Shipment create(Shipment s){
        return repo.save(s);
    }

    public Shipment getShipment(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment Not Found"));
    }
}
