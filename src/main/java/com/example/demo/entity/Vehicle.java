package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;

    private double capacityKg;

    // NEW FIELD REQUIRED BY TESTS
    private double fuelEfficiency;   // km per litre or similar

    @ManyToOne
    private User user;
}
