package com.example.demo.entity;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    private Long id;
    private Vehicle vehicle;
    private Location pickupLocation;
    private Location dropLocation;
    private Double weightKg;
    private LocalDate scheduledDate;
}
