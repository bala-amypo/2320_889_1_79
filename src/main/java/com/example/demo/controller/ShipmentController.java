package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    
    private final ShipmentService shipmentService;
    
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    
    @PostMapping("/{vehicleId}")
    public ResponseEntity<?> createShipment(@PathVariable Long vehicleId, 
                                           @RequestBody Shipment shipment) {
        try {
            Shipment savedShipment = shipmentService.createShipment(vehicleId, shipment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedShipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @GetMapping("/{shipmentId}")
    public ResponseEntity<?> getShipment(@PathVariable Long shipmentId) {
        try {
            Shipment shipment = shipmentService.getShipment(shipmentId);
            return ResponseEntity.ok(shipment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}