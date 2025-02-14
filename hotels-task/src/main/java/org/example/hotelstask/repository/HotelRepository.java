package org.example.hotelstask.repository;

import org.example.hotelstask.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    @Query("SELECT h FROM Hotel h " +
            "WHERE (:name IS NULL OR LOWER(h.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:brand IS NULL OR LOWER(h.brand) LIKE LOWER(CONCAT('%', :brand, '%'))) " +
            "AND (:city IS NULL OR LOWER(h.address.city) LIKE LOWER(CONCAT('%', :city, '%'))) " +
            "AND (:country IS NULL OR LOWER(h.address.country) LIKE LOWER(CONCAT('%', :country, '%')))")
    List<Hotel> searchHotels(@Param("name") String name,
                             @Param("brand") String brand,
                             @Param("city") String city,
                             @Param("country") String country);

    @Query("SELECT a.name, COUNT(h) FROM Hotel h JOIN h.amenities a GROUP BY a.name")
    List<Object[]> countHotelsByAmenities();

    @Query("SELECT h.brand, COUNT(h) FROM Hotel h GROUP BY h.brand")
    List<Object[]> countHotelsByBrand();

    @Query("SELECT h.address.city, COUNT(h) FROM Hotel h GROUP BY h.address.city")
    List<Object[]> countHotelsByCity();

    @Query("SELECT h.address.country, COUNT(h) FROM Hotel h GROUP BY h.address.country")
    List<Object[]> countHotelsByCountry();
}
