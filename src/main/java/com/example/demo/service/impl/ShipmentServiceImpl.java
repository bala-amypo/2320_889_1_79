package com.example.demo.service.impl;

import com.example.demo.entity.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl {

    public boolean canShip(double shipmentWeight, Vehicle vehicle) {
        return shipmentWeight <= vehicle.getCapacityKg();
    }
}
