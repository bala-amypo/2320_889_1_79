package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {
        this.repo = repo;
    }

    public Location createLocation(Location l) {
        if (l.getLatitude() < -90 || l.getLatitude() > 90)
            throw new IllegalArgumentException("Invalid latitude");
        return repo.save(l);
    }

    public List<Location> getAllLocations() {
        return repo.findAll();
    }
}
