package org.example.hotelstask.mapper;


import org.example.hotelstask.dto.arrival.ArrivalTimeDto;
import org.example.hotelstask.model.ArrivalTime;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ArrivalTimeMapper {
    ArrivalTimeDto toDto(ArrivalTime arrivalTime);
}
