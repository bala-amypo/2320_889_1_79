package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String type;
    private double capacityKg;
    private double fuelEfficiency;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name="vehicle_locations",
            joinColumns=@JoinColumn(name="vehicle_id"),
            inverseJoinColumns=@JoinColumn(name="location_id")
    )
    private Set<Location> locations = new HashSet<>();

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}

    public String getVehicleNumber(){ return vehicleNumber;}
    public void setVehicleNumber(String vehicleNumber){ this.vehicleNumber=vehicleNumber;}

    public String getType(){ return type;}
    public void setType(String type){ this.type=type;}

    public double getCapacityKg(){ return capacityKg;}
    public void setCapacityKg(double capacityKg){ this.capacityKg=capacityKg;}

    public double getFuelEfficiency(){ return fuelEfficiency;}
    public void setFuelEfficiency(double fuelEfficiency){ this.fuelEfficiency=fuelEfficiency;}

    public User getUser(){ return user;}
    public void setUser(User user){ this.user=user;}

    public Set<Location> getLocations(){ return locations;}
    public void setLocations(Set<Location> locations){ this.locations=locations;}
}
