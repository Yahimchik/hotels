package org.example.hotelstask.util;

import org.example.hotelstask.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressUtils {
    public static String toAddress(Address address) {
        if (address == null) {
            return "";
        }
        return address.getHouseNumber()
                + " " + address.getStreet()
                + ", " + address.getCity()
                + ", " + address.getPostCode()
                + ", " + address.getCountry();
    }
}
