package org.example.hotelstask.util;

import org.example.hotelstask.model.Amenity;
import org.springframework.stereotype.Component;

@Component
public class AmenityUtils {
    public static String toAmenity(Amenity amenity) {
        if (amenity == null) {
            return null;
        }
        return amenity.getName();
    }
}
