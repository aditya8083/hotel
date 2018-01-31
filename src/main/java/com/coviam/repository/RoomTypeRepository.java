package com.coviam.repository;

import com.coviam.Entity.Dao.RoomTypeDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomTypeDao, Long> {
}

