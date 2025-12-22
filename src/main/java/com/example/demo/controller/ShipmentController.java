package com.example.demo.controller;

import com.example.demo.dto.ShipmentDTO;
import com.example.demo.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public ShipmentDTO createShipment(@Valid @RequestBody ShipmentDTO shipmentDTO) {
        return shipmentService.createShipment(shipmentDTO);
    }

    @GetMapping("/{id}")
    public ShipmentDTO getShipment(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @GetMapping
    public List<ShipmentDTO> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @PutMapping("/{id}")
    public ShipmentDTO updateShipment(@PathVariable Long id,
                                      @Valid @RequestBody ShipmentDTO shipmentDTO) {
        return shipmentService.updateShipment(id, shipmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}