package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicles", uniqueConstraints = {@UniqueConstraint(columnNames = "vehicleNumber")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;
}
