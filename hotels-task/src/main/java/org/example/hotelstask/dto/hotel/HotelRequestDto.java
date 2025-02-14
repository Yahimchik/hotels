package org.example.hotelstask.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hotelstask.dto.address.AddressDto;
import org.example.hotelstask.dto.arrival.ArrivalTimeDto;
import org.example.hotelstask.dto.contacts.ContactsDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequestDto {
    private String name;
    private String description;
    private String brand;
    private AddressDto address;
    private ContactsDto contacts;
    private ArrivalTimeDto arrivalTime;
    private List<String> amenities;
}
