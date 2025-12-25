package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double weightKg;

    private LocalDate scheduledDate;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    @ManyToOne
    private Vehicle vehicle;
}
