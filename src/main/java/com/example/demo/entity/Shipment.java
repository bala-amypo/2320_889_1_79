package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name="shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private Vehicle vehicle;

    @ManyToOne(optional=false)
    private Location pickupLocation;

    @ManyToOne(optional=false)
    private Location dropLocation;

    private Double weightKg;

    private LocalDate scheduledDate;
}
