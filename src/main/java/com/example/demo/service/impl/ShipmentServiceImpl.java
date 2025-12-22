package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentServiceImpl(ShipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        return repository.save(shipment);
    }

    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existing = getShipmentById(id);

        existing.setWeightKg(shipment.getWeightKg());
        existing.setScheduledDate(shipment.getScheduledDate());
        existing.setPickupLocation(shipment.getPickupLocation());
        existing.setDropLocation(shipment.getDropLocation());

        return repository.save(existing);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return repository.findAll();
    }

    @Override
    public void deleteShipment(Long id) {
        repository.deleteById(id);
    }
}
