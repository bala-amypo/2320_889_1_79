package com.example.demo.entity;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private Long id;
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;
    private User user;
}
