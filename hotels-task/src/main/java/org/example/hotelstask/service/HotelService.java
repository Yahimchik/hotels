package org.example.hotelstask.service;

import org.example.hotelstask.dto.hotel.HotelRequestDto;
import org.example.hotelstask.dto.hotel.HotelResponseDetailsDto;
import org.example.hotelstask.dto.hotel.HotelResponseDto;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    List<HotelResponseDto> getAllHotels();

    HotelResponseDetailsDto getHotelById(UUID id);

    List<HotelResponseDto> searchHotels(String name, String brand, String city, String county);

    HotelResponseDto createHotel(HotelRequestDto requestDto);
}
