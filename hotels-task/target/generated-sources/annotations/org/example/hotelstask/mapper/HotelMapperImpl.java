package org.example.hotelstask.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.example.hotelstask.dto.hotel.HotelResponseDetailsDto;
import org.example.hotelstask.dto.hotel.HotelResponseDto;
import org.example.hotelstask.model.Amenity;
import org.example.hotelstask.model.Contacts;
import org.example.hotelstask.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-14T11:40:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class HotelMapperImpl implements HotelMapper {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ContactsMapper contactsMapper;
    @Autowired
    private ArrivalTimeMapper arrivalTimeMapper;
    @Autowired
    private AmenityMapper amenityMapper;

    @Override
    public HotelResponseDto toResponseDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelResponseDto hotelResponseDto = new HotelResponseDto();

        hotelResponseDto.setPhone( hotelContactsPhone( hotel ) );
        hotelResponseDto.setId( hotel.getId() );
        hotelResponseDto.setName( hotel.getName() );
        hotelResponseDto.setDescription( hotel.getDescription() );
        hotelResponseDto.setAddress( addressMapper.toAddress( hotel.getAddress() ) );

        return hotelResponseDto;
    }

    @Override
    public HotelResponseDetailsDto toDetailsDto(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelResponseDetailsDto hotelResponseDetailsDto = new HotelResponseDetailsDto();

        hotelResponseDetailsDto.setId( hotel.getId() );
        hotelResponseDetailsDto.setName( hotel.getName() );
        hotelResponseDetailsDto.setBrand( hotel.getBrand() );
        hotelResponseDetailsDto.setAddress( addressMapper.toDto( hotel.getAddress() ) );
        hotelResponseDetailsDto.setContacts( contactsMapper.toDto( hotel.getContacts() ) );
        hotelResponseDetailsDto.setArrivalTime( arrivalTimeMapper.toDto( hotel.getArrivalTime() ) );
        hotelResponseDetailsDto.setAmenities( amenitySetToStringList( hotel.getAmenities() ) );

        return hotelResponseDetailsDto;
    }

    private String hotelContactsPhone(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }
        Contacts contacts = hotel.getContacts();
        if ( contacts == null ) {
            return null;
        }
        String phone = contacts.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    protected List<String> amenitySetToStringList(Set<Amenity> set) {
        if ( set == null ) {
            return null;
        }

        List<String> list = new ArrayList<String>( set.size() );
        for ( Amenity amenity : set ) {
            list.add( amenityMapper.amenityToString( amenity ) );
        }

        return list;
    }
}
