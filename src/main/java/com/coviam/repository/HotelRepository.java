package com.coviam.repository;

import com.coviam.entity.Dao.HotelDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelDao, Long> {

    List<HotelDao> findByHotelLocation(String hotelLocation);

    @Query("select h from HotelDao h where h.city = :city")
    List<HotelDao> findByCity(@Param("city") String city);

    @Query("select h from HotelDao h where h.city = :city AND h.starRating >= :starRating")
    List<HotelDao> findByStarRating(@Param("city") String city, @Param("starRating")String starRating);

    @Query("select h.hotelId from HotelDao h where h.city = :city ")
    List<Long> findHotelIdByHotelLocation(@Param("city") String city);

    @Query("select h from HotelDao h where h.hotelId in :filteredHotelIdsWithoutDuplicates ")
    List<HotelDao> findHotelByHotelIds(@Param("filteredHotelIdsWithoutDuplicates") List<Long> filteredHotelIdsWithoutDuplicates);

    @Query("select h from HotelDao h where h.hotelId = :hotelId ")
    HotelDao findHotelById(@Param("hotelId") Long hotelId);
}
