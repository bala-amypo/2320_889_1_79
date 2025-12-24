package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentCode;
    private double weightKg;
    private LocalDate scheduledDate;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}

    public String getShipmentCode(){ return shipmentCode;}
    public void setShipmentCode(String shipmentCode){ this.shipmentCode=shipmentCode;}

    public double getWeightKg(){ return weightKg;}
    public void setWeightKg(double weightKg){ this.weightKg=weightKg;}

    public LocalDate getScheduledDate(){ return scheduledDate;}
    public void setScheduledDate(LocalDate scheduledDate){ this.scheduledDate=scheduledDate;}

    public Vehicle getVehicle(){ return vehicle;}
    public void setVehicle(Vehicle vehicle){ this.vehicle=vehicle;}

    public Location getPickupLocation(){ return pickupLocation;}
    public void setPickupLocation(Location pickupLocation){ this.pickupLocation=pickupLocation;}

    public Location getDropLocation(){ return dropLocation;}
    public void setDropLocation(Location dropLocation){ this.dropLocation=dropLocation;}
}
