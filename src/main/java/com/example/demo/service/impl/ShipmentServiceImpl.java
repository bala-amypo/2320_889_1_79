package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment){
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipment(Long id){
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    @Override
    public List<Shipment> getAllShipments(){
        return shipmentRepository.findAll();
    }
}
