package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;

    private Double capacityKg;

    private Double fuelEfficiency;   // <-- REQUIRED

    @ManyToOne
    private User user;
}
