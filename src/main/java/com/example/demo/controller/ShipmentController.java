package com.example.demo.controller;

import com.example.demo.entity.Shipment;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public Shipment create(@RequestBody Shipment shipment) {
        return service.create(shipment);
    }

    @GetMapping("/{id}")
    public Shipment get(@PathVariable Long id) {
        return service.getShipment(id);
    }
}
