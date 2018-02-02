package com.coviam.repository;


import com.coviam.entity.model.BookingUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingUserDetailsRepository extends JpaRepository<BookingUserDetails,Long>  {
}
