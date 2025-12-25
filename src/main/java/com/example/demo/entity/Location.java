package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public Location(){}

    public Long getId(){ return id;}
    public String getName(){ return name;}
    public void setName(String n){ this.name=n;}
    public Double getLatitude(){ return latitude;}
    public void setLatitude(Double l){ this.latitude=l;}
    public Double getLongitude(){ return longitude;}
    public void setLongitude(Double l){ this.longitude=l;}
}
