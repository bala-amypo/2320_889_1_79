package com.example.demo.repository;

import com.example.demo.entity.Shipment;
import java.util.*;

public interface ShipmentRepository {
    Shipment save(Shipment s);
    Optional<Shipment> findById(Long id);
    List<Shipment> findByVehicleId(Long vehicleId);
}
