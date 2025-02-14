package org.example.hotelstask.mapper;

import javax.annotation.processing.Generated;
import org.example.hotelstask.dto.address.AddressDto;
import org.example.hotelstask.model.Address;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-14T11:40:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setHouseNumber( address.getHouseNumber() );
        addressDto.setStreet( address.getStreet() );
        addressDto.setCity( address.getCity() );
        addressDto.setCountry( address.getCountry() );
        addressDto.setPostCode( address.getPostCode() );

        return addressDto;
    }
}
