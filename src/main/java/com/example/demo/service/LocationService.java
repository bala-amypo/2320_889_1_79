package com.example.demo.service;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {
    
    private final LocationRepository locationRepository;
    
    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    
    public Location createLocation(Location location) {
        // Validate latitude
        if (location.getLatitude() == null || location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("latitude must be between -90 and 90");
        }
        
        return locationRepository.save(location);
    }
    
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}