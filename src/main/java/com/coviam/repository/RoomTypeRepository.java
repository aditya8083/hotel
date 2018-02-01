package com.coviam.repository;

import com.coviam.Entity.Dao.RoomTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeDao, Long> {

    @Query("select rt.hotelId from RoomTypeDao rt where rt.hotelId in :searchedHotelIds AND rt.roomPrice >= :minPrice AND rt.roomPrice <= :maxPrice")
    List<Long> findHotelIdByPriceFilter(@Param("searchedHotelIds") List<Long> searchedHotelIds, @Param("minPrice") String minPrice, @Param("maxPrice") String maxPrice);

    @Query("select rt from RoomTypeDao rt where rt.hotelId =:hotelId ")
    List<RoomTypeDao> findRoomsByHotelId(@Param("hotelId") Long hotelId);
}

