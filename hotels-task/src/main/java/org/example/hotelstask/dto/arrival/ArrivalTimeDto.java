package org.example.hotelstask.dto.arrival;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArrivalTimeDto {
    private String checkIn;
    private String checkOut;
}
