package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;
    private final LocationRepository locationRepo;

    public ShipmentServiceImpl(
            ShipmentRepository shipmentRepo,
            VehicleRepository vehicleRepo,
            LocationRepository locationRepo
    ) {
        this.shipmentRepo = shipmentRepo;
        this.vehicleRepo = vehicleRepo;
        this.locationRepo = locationRepo;
    }

    @Override
    public Shipment createShipment(long userId, Shipment shipment) {
        return shipmentRepo.save(shipment);
    }
}
