package org.example.hotelstask.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotelstask.model.Amenity;
import org.example.hotelstask.model.Hotel;
import org.example.hotelstask.repository.HotelRepository;
import org.example.hotelstask.service.AmenityService;
import org.example.hotelstask.service.helper.AmenityServiceHelper;
import org.example.hotelstask.service.helper.HotelServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AmenityServiceImpl implements AmenityService {

    private final HotelRepository hotelRepository;
    private final AmenityServiceHelper amenityServiceHelper;
    private final HotelServiceHelper hotelServiceHelper;

    @Override
    @Transactional
    public void addAmenitiesToHotel(UUID hotelId, List<String> amenities) {
        Hotel hotel = hotelServiceHelper.isHotelExist(hotelId);
        Set<Amenity> amenitiesToAdd = amenityServiceHelper.mapAmenities(amenities);
        hotel.getAmenities().addAll(amenitiesToAdd);
        hotelRepository.save(hotel);
    }


}

