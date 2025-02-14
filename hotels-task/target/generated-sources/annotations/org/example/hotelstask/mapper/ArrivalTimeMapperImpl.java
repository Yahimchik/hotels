package org.example.hotelstask.mapper;

import javax.annotation.processing.Generated;
import org.example.hotelstask.dto.arrival.ArrivalTimeDto;
import org.example.hotelstask.model.ArrivalTime;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-14T11:40:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ArrivalTimeMapperImpl implements ArrivalTimeMapper {

    @Override
    public ArrivalTimeDto toDto(ArrivalTime arrivalTime) {
        if ( arrivalTime == null ) {
            return null;
        }

        ArrivalTimeDto arrivalTimeDto = new ArrivalTimeDto();

        arrivalTimeDto.setCheckIn( arrivalTime.getCheckIn() );
        arrivalTimeDto.setCheckOut( arrivalTime.getCheckOut() );

        return arrivalTimeDto;
    }
}
