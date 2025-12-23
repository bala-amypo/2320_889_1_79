package com.example.demo.service.impl;

import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    
    private final LocationRepository locationRepository;
    
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
    
    @Override
    public Location createLocation(Location location) {
        if (location.getLatitude() == null || location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("latitude must be between -90 and 90");
        }
        return locationRepository.save(location);
    }
    
    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
    
    @Override
    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
    }
    
    @Override
    public Location updateLocation(Long id, Location location) {
        Location existingLocation = getLocationById(id);
        existingLocation.setName(location.getName());
        existingLocation.setLatitude(location.getLatitude());
        existingLocation.setLongitude(location.getLongitude());
        return locationRepository.save(existingLocation);
    }
    
    @Override
    public void deleteLocation(Long id) {
        Location location = getLocationById(id);
        locationRepository.delete(location);
    }
}