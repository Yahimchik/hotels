package org.example.hotelstask.mapper;

import org.example.hotelstask.dto.address.AddressDto;
import org.example.hotelstask.model.Address;
import org.example.hotelstask.util.AddressUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AddressMapper {
    AddressDto toDto(Address address);

    default String toAddress(Address address) {
        return AddressUtils.toAddress(address);
    }
}