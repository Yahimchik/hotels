package org.example.hotelstask.mapper;


import org.example.hotelstask.model.Amenity;
import org.example.hotelstask.util.AmenityUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AmenityMapper {
    default String amenityToString(Amenity amenity) {
        return AmenityUtils.toAmenity(amenity);
    }
}