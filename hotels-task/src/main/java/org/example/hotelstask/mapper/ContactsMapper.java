package org.example.hotelstask.mapper;

import org.example.hotelstask.dto.contacts.ContactsDto;
import org.example.hotelstask.model.Contacts;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ContactsMapper {
    ContactsDto toDto(Contacts contact);
}

