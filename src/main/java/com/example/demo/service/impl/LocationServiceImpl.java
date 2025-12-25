package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo){
        this.repo = repo;
    }

    public Location create(Location l){
        if(l.getLatitude() < -90 || l.getLatitude() > 90)
            throw new IllegalArgumentException("Invalid latitude");

        return repo.save(l);
    }

    public List<Location> getAll(){
        return repo.findAll();
    }
}
