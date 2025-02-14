package org.example.hotelstask.service;

import java.util.Map;

public interface HistogramService {
    Map<String, Long> getHotelCountByBrand();

    Map<String, Long> getHotelCountByCity();

    Map<String, Long> getHotelCountByCountry();

    Map<String, Long> getHotelCountByAmenities();
}
