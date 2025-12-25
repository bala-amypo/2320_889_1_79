package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {
    Location create(Location l);
    List<Location> getAll();
}
