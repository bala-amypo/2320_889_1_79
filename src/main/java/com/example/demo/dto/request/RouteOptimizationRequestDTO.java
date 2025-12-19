package com.example.demo.dto.request;

import jakarta.validation.constraints.NotNull;

public class RouteOptimizationRequestDTO {

    @NotNull(message = "Shipment ID is required")
    private Long shipmentId;

    // Getter & Setter
    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }
}
