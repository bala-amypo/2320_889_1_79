package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment(){}

    public Long getId(){ return id;}
    public Vehicle getVehicle(){ return vehicle;}
    public void setVehicle(Vehicle v){ this.vehicle=v;}
    public Location getPickupLocation(){ return pickupLocation;}
    public void setPickupLocation(Location l){ this.pickupLocation=l;}
    public Location getDropLocation(){ return dropLocation;}
    public void setDropLocation(Location l){ this.dropLocation=l;}
    public Double getWeightKg(){ return weightKg;}
    public void setWeightKg(Double w){ this.weightKg=w;}
    public LocalDate getScheduledDate(){ return scheduledDate;}
    public void setScheduledDate(LocalDate d){ this.scheduledDate=d;}
}
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location source;

    @ManyToOne
    private Location destination;

    private double weight;
}
