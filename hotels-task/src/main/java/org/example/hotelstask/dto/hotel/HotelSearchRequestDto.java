package org.example.hotelstask.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelSearchRequestDto {
    private String name;
    private String brand;
    private String city;
    private String country;
    private List<String> amenities;
}
