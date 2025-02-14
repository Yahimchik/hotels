package org.example.hotelstask.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelResponseDto {
    private UUID id;
    private String name;
    private String description;
    private String address;
    private String phone;
}
