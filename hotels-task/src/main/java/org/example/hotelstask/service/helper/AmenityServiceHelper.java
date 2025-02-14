package org.example.hotelstask.service.helper;

import lombok.RequiredArgsConstructor;
import org.example.hotelstask.model.Amenity;
import org.example.hotelstask.repository.AmenityRepository;
import org.example.hotelstask.util.UuidGenerator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AmenityServiceHelper {

    private final AmenityRepository amenityRepository;
    private final UuidGenerator uuidGenerator;

    public Set<Amenity> mapAmenities(List<String> amenities) {
        return amenities.stream()
                .map(name -> amenityRepository.findByName(name)
                        .orElseGet(() -> Amenity.builder()
                                .id(uuidGenerator.generateUUID())
                                .name(name)
                                .build()))
                .collect(Collectors.toSet());
    }

    public List<String> extractAmenities(Set<Amenity> amenities) {
        return amenities.stream()
                .map(Amenity::getName)
                .toList();
    }
}
