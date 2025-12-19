package com.example.demo.dto.response;

import java.time.LocalDate;

public class ShipmentResponseDTO {

    private Long id;
    private Double weightKg;
    private LocalDate scheduledDate;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeightKg() {
        return weightKg;
    }
    
    public void setWeightKg(Double weightKg) {
        this.weightKg = weightKg;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }
    
    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
}
