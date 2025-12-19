package com.example.demo.service.impl;

import com.example.demo.dto.LocationDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {
        this.repo = repo;
    }

    @Override
    public LocationDTO createLocation(LocationDTO dto) {
        Location loc = new Location();
        loc.setName(dto.getName());
        loc.setLatitude(dto.getLatitude());
        loc.setLongitude(dto.getLongitude());

        Location saved = repo.save(loc);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location loc = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));
        return mapToDTO(loc);
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        return repo.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LocationDTO mapToDTO(Location loc) {
        LocationDTO dto = new LocationDTO();
        dto.setId(loc.getId());
        dto.setName(loc.getName());
        dto.setLatitude(loc.getLatitude());
        dto.setLongitude(loc.getLongitude());
        return dto;
    }
}
