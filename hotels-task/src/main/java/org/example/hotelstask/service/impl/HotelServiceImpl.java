package org.example.hotelstask.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.hotelstask.dto.hotel.HotelRequestDto;
import org.example.hotelstask.dto.hotel.HotelResponseDetailsDto;
import org.example.hotelstask.dto.hotel.HotelResponseDto;
import org.example.hotelstask.mapper.HotelMapper;
import org.example.hotelstask.model.Hotel;
import org.example.hotelstask.repository.HotelRepository;
import org.example.hotelstask.service.HotelService;
import org.example.hotelstask.service.helper.HotelServiceHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;
    private final HotelServiceHelper hotelServiceHelper;

    @Override
    @Transactional(readOnly = true)
    public List<HotelResponseDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HotelResponseDetailsDto getHotelById(UUID id) {
        return hotelRepository.findById(id)
                .map(hotelMapper::toDetailsDto)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<HotelResponseDto> searchHotels(String name, String brand, String city, String county) {
        return hotelRepository.searchHotels(name, brand, city, county).stream()
                .map(hotelMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public HotelResponseDto createHotel(HotelRequestDto requestDto) {
        Hotel hotel = hotelServiceHelper.createHotelFromRequest(requestDto);
        Hotel savedHotel = hotelRepository.save(hotel);
        return hotelMapper.toResponseDto(savedHotel);
    }
}
