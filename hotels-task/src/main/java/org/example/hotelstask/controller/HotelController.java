package org.example.hotelstask.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelstask.dto.hotel.HotelRequestDto;
import org.example.hotelstask.dto.hotel.HotelResponseDetailsDto;
import org.example.hotelstask.dto.hotel.HotelResponseDto;
import org.example.hotelstask.service.AmenityService;
import org.example.hotelstask.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/property-view/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final AmenityService amenityService;

    @GetMapping
    public List<HotelResponseDto> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public HotelResponseDetailsDto getHotelById(@PathVariable UUID id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/search")
    public List<HotelResponseDto> searchHotels(@RequestParam(required = false) String name,
                                               @RequestParam(required = false) String brand,
                                               @RequestParam(required = false) String city,
                                               @RequestParam(required = false) String country) {
        return hotelService.searchHotels(name, brand, city, country);
    }

    @PostMapping
    public HotelResponseDto createHotel(@RequestBody HotelRequestDto requestDto) {
        return hotelService.createHotel(requestDto);
    }

    @PostMapping("/{id}/amenities")
    public void addAmenitiesToHotel(@PathVariable UUID id, @RequestBody List<String> amenities) {
        amenityService.addAmenitiesToHotel(id, amenities);
    }
}

