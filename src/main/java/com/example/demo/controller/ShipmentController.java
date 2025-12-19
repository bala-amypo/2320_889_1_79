package com.example.demo.controller;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentDTO> createShipment(@Valid @RequestBody ShipmentDTO dto) {
        return new ResponseEntity<>(shipmentService.createShipment(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentDTO> getShipment(@PathVariable Long id) {
        return ResponseEntity.ok(shipmentService.getShipmentById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShipmentDTO>> getAllShipments() {
        return ResponseEntity.ok(shipmentService.getAllShipments());
    }
}