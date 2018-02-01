package com.coviam.Entity.Dao;


import com.coviam.util.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "HotelRoomAvailabilityDao")
@Table(name = "HotelRoomAvailabilityDao")
@EntityListeners(AuditingEntityListener.class)
public class HotelRoomAvailabilityDao extends Auditable<String> {



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1, initialValue = 1)
    private Long id;
    private String hotelId;
    private String roomTypeId;
    private String checkInDate;
    private String checkOutDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public HotelRoomAvailabilityDao(Long id, String hotelId, String roomTypeId, String checkInDate, String checkOutDate) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public HotelRoomAvailabilityDao() {
    }

    @Override
    public String toString() {
        return "HotelRoomAvailabilityDao{" +
                "id=" + id +
                ", hotelId='" + hotelId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
