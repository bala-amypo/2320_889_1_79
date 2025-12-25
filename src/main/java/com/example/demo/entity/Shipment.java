package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;

    private double weight;

    private String status;

    @ManyToOne
    @JoinColumn(name = "source_location_id")
    private Location source;

    @ManyToOne
    @JoinColumn(name = "destination_location_id")
    private Location destination;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
