package org.example.hotelstask.mapper;

import javax.annotation.processing.Generated;
import org.example.hotelstask.dto.contacts.ContactsDto;
import org.example.hotelstask.model.Contacts;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-14T11:40:47+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ContactsMapperImpl implements ContactsMapper {

    @Override
    public ContactsDto toDto(Contacts contact) {
        if ( contact == null ) {
            return null;
        }

        ContactsDto contactsDto = new ContactsDto();

        contactsDto.setPhone( contact.getPhone() );
        contactsDto.setEmail( contact.getEmail() );

        return contactsDto;
    }
}
