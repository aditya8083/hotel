package com.coviam.repository;

import com.coviam.entity.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Booking findByBookingReference(String bookingReference);
}
