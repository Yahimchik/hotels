package org.example.hotelstask.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotelstask.service.HistogramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/property-view/histogram")
@RequiredArgsConstructor
public class HistogramController {

    private final HistogramService histogramService;

    @GetMapping("/{param}")
    public Map<String, Long> getHotelsByParam(@PathVariable String param) {
        return switch (param.toLowerCase()) {
            case "brand" -> histogramService.getHotelCountByBrand();
            case "city" -> histogramService.getHotelCountByCity();
            case "country" -> histogramService.getHotelCountByCountry();
            case "amenities" -> histogramService.getHotelCountByAmenities();
            default -> throw new IllegalArgumentException("Invalid parameter: " + param);
        };
    }
}
