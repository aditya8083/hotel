package com.coviam.repository;

import com.coviam.Entity.Dao.HotelRoomAvailabilityDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRoomAvailabilityRepository extends JpaRepository<HotelRoomAvailabilityDao, Long>{
}
