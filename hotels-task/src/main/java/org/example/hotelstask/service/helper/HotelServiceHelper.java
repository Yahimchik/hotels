package org.example.hotelstask.service.helper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.hotelstask.dto.hotel.HotelRequestDto;
import org.example.hotelstask.model.Address;
import org.example.hotelstask.model.ArrivalTime;
import org.example.hotelstask.model.Contacts;
import org.example.hotelstask.model.Hotel;
import org.example.hotelstask.repository.HotelRepository;
import org.example.hotelstask.util.UuidGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HotelServiceHelper {

    private final UuidGenerator uuidGenerator;
    private final HotelRepository hotelRepository;

    public Hotel isHotelExist(UUID hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new EntityNotFoundException("Hotel not found"));
    }

    public Hotel createHotelFromRequest(HotelRequestDto requestDto) {
        return Hotel.builder()
                .id(uuidGenerator.generateUUID())
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .brand(requestDto.getBrand())
                .address(Address.builder()
                        .id(uuidGenerator.generateUUID())
                        .houseNumber(requestDto.getAddress().getHouseNumber())
                        .street(requestDto.getAddress().getStreet())
                        .city(requestDto.getAddress().getCity())
                        .country(requestDto.getAddress().getCountry())
                        .postCode(requestDto.getAddress().getPostCode())
                        .build())
                .contacts(Contacts.builder()
                        .id(uuidGenerator.generateUUID())
                        .phone(requestDto.getContacts().getPhone())
                        .email(requestDto.getContacts().getEmail())
                        .build())
                .arrivalTime(ArrivalTime.builder()
                        .id(uuidGenerator.generateUUID())
                        .checkIn(requestDto.getArrivalTime().getCheckIn())
                        .checkOut(requestDto.getArrivalTime().getCheckOut())
                        .build())
                .build();
    }
}
