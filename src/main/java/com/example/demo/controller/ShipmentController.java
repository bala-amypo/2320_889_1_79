package com.example.demo.controller;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService service;

    public ShipmentController(ShipmentService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentDTO create(@RequestBody ShipmentDTO dto) {
        return service.createShipment(dto);
    }

    @GetMapping("/{id}")
    public ShipmentDTO getById(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentDTO> getAll() {
        return service.getAllShipments();
    }
}
