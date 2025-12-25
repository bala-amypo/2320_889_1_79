package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service){
        this.service = service;
    }

    @PostMapping("/{vehicleId}")
    public Shipment create(@PathVariable Long vehicleId, @RequestBody Shipment s){
        return service.createShipment(vehicleId, s);
    }

    @GetMapping("/{shipmentId}")
    public Shipment get(@PathVariable Long shipmentId){
        return service.getShipment(shipmentId);
    }
}
