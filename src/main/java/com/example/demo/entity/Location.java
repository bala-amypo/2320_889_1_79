package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private double latitude;
    private double longitude;

    @ManyToMany(mappedBy="locations")
    private Set<Vehicle> vehicles = new HashSet<>();

    public Long getId(){ return id;}
    public void setId(Long id){ this.id=id;}

    public String getCity(){ return city;}
    public void setCity(String city){ this.city=city;}

    public double getLatitude(){ return latitude;}
    public void setLatitude(double latitude){ this.latitude=latitude;}

    public double getLongitude(){ return longitude;}
    public void setLongitude(double longitude){ this.longitude=longitude;}

    public Set<Vehicle> getVehicles(){ return vehicles;}
    public void setVehicles(Set<Vehicle> vehicles){ this.vehicles=vehicles;}
}
