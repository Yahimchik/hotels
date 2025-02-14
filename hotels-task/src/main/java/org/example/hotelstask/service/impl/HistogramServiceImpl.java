package org.example.hotelstask.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.hotelstask.repository.HotelRepository;
import org.example.hotelstask.service.HistogramService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistogramServiceImpl implements HistogramService {

    private final HotelRepository hotelRepository;

    @Override
    @Transactional
    public Map<String, Long> getHotelCountByBrand() {
        List<Object[]> results = hotelRepository.countHotelsByBrand();
        return toMapFromList(results);
    }

    @Override
    @Transactional
    public Map<String, Long> getHotelCountByCity() {
        List<Object[]> results = hotelRepository.countHotelsByCity();
        return toMapFromList(results);
    }

    @Override
    @Transactional
    public Map<String, Long> getHotelCountByCountry() {
        List<Object[]> results = hotelRepository.countHotelsByCountry();
        return toMapFromList(results);
    }

    @Override
    @Transactional
    public Map<String, Long> getHotelCountByAmenities() {
        List<Object[]> results = hotelRepository.countHotelsByAmenities();
        return toMapFromList(results);
    }

    private Map<String, Long> toMapFromList(List<Object[]> results) {
        return results.stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (Long) result[1]
                ));
    }
}

