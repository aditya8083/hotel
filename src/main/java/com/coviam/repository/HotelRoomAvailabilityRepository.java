package com.coviam.repository;

import com.coviam.entity.Dao.HotelRoomAvailabilityDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomAvailabilityRepository extends JpaRepository<HotelRoomAvailabilityDao, Long>{
}
