package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.Id;

public class Shipment {

    @Id
    private Long id;
    private Double weightKg;
    private LocalDate scheduleDate;

}