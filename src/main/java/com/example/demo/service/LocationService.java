package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Location;

public interface LocationService {

    Location createLocation(Location location);

    Location getLocationById(Long id);

    List<Location> getAllLocations();

    Location updateLocation(Long id, Location location);

    void deleteLocation(Long id);
}