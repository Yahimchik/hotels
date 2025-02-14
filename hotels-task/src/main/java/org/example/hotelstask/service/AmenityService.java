package org.example.hotelstask.service;

import java.util.List;
import java.util.UUID;

public interface AmenityService {
    void addAmenitiesToHotel(UUID hotelId, List<String> amenities);
}

