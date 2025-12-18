package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    // Constructor Injection ONLY
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/vehicle/{vehicleId}")
    public Shipment createShipment(@PathVariable Long vehicleId,
                                   @RequestBody Shipment shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable Long id) {
        return shipmentService.getShipment(id);
    }
}