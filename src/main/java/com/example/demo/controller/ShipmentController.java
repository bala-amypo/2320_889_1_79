package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    
    @Autowired
    private ShipmentService shipmentService;
    
    @PostMapping("/{vehicleId}")
    public ResponseEntity<?> createShipment(@PathVariable Long vehicleId, 
                                           @RequestBody Shipment shipment) {
        Shipment savedShipment = shipmentService.createShipment(vehicleId, shipment);
        return ResponseEntity.ok(savedShipment);
    }
    
    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(shipmentService.getShipment(shipmentId));
    }
}