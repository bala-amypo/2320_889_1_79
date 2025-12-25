package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.*;

public interface LocationService {
    Location createLocation(Location l);
    List<Location> getAllLocations();
    Location findById(Long id);
}
