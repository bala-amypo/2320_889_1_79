package com.example.demo.service.impl;

import com.example.demo.dto.LocationDTO;
import com.example.demo.entity.Location;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    private LocationDTO mapToDTO(Location location) {
        return new LocationDTO(
                location.getId(),
                location.getName(),
                location.getLatitude(),
                location.getLongitude()
        );
    }

    private Location mapToEntity(LocationDTO dto) {
        return new Location(
                dto.getId(),
                dto.getName(),
                dto.getLatitude(),
                dto.getLongitude()
        );
    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = mapToEntity(locationDTO);
        return mapToDTO(locationRepository.save(location));
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + id));
        return mapToDTO(location);
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location not found with id " + id));

        location.setName(locationDTO.getName());
        location.setLatitude(locationDTO.getLatitude());
        location.setLongitude(locationDTO.getLongitude());

        return mapToDTO(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(Long id) {
        if (!locationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Location not found with id " + id);
        }
        locationRepository.deleteById(id);
    }
}