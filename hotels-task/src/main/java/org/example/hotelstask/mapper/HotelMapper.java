package org.example.hotelstask.mapper;

import org.example.hotelstask.dto.hotel.HotelResponseDetailsDto;
import org.example.hotelstask.dto.hotel.HotelResponseDto;
import org.example.hotelstask.model.Hotel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        uses = {AddressMapper.class,
                ContactsMapper.class,
                ArrivalTimeMapper.class,
                AmenityMapper.class
        })
public interface HotelMapper {

    @Mapping(source = "contacts.phone", target = "phone")
    HotelResponseDto toResponseDto(Hotel hotel);

    HotelResponseDetailsDto toDetailsDto(Hotel hotel);
}