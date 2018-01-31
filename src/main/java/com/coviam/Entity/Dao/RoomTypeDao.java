package com.coviam.Entity.Dao;


import com.coviam.util.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "RoomTypeDao")
@Table(name = "room_type")
@EntityListeners(AuditingEntityListener.class)
public class RoomTypeDao extends Auditable<String> {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "room_id", sequenceName = "room_id", allocationSize = 1, initialValue = 20000)
    private Long roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_price")
    private String roomPrice;

    @Column(name = "no_of_beds")
    private String NoOfBeds;

    @Column(name = "is_free_breakfast")
    private String isFreeBreakfast;

    @Column(name = "is_free_wifi")
    private String isFreeWifi;

    @Column(name = "max_adult")
    private String maxAdult;

    @Column(name = "max_child")
    private String maxChild;

    @Column(name = "no_of_rooms")
    private String noOfRooms;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "room_image")
    private String roomImage;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getNoOfBeds() {
        return NoOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) {
        NoOfBeds = noOfBeds;
    }

    public String getIsFreeBreakfast() {
        return isFreeBreakfast;
    }

    public void setIsFreeBreakfast(String isFreeBreakfast) {
        this.isFreeBreakfast = isFreeBreakfast;
    }

    public String getIsFreeWifi() {
        return isFreeWifi;
    }

    public void setIsFreeWifi(String isFreeWifi) {
        this.isFreeWifi = isFreeWifi;
    }

    public String getMaxAdult() {
        return maxAdult;
    }

    public void setMaxAdult(String maxAdult) {
        this.maxAdult = maxAdult;
    }

    public String getMaxChild() {
        return maxChild;
    }

    public void setMaxChild(String maxChild) {
        this.maxChild = maxChild;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public RoomTypeDao(String roomName, String roomPrice, String noOfBeds, String isFreeBreakfast, String isFreeWifi, String maxAdult, String maxChild, String noOfRooms, Long hotelId, String roomImage) {
        this.roomName = roomName;
        this.roomPrice = roomPrice;
        NoOfBeds = noOfBeds;
        this.isFreeBreakfast = isFreeBreakfast;
        this.isFreeWifi = isFreeWifi;
        this.maxAdult = maxAdult;
        this.maxChild = maxChild;
        this.noOfRooms = noOfRooms;
        this.hotelId = hotelId;
        this.roomImage = roomImage;
    }


    public RoomTypeDao() {
    }

    @Override
    public String toString() {
        return "RoomTypeDao{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", NoOfBeds='" + NoOfBeds + '\'' +
                ", isFreeBreakfast='" + isFreeBreakfast + '\'' +
                ", isFreeWifi='" + isFreeWifi + '\'' +
                ", maxAdult='" + maxAdult + '\'' +
                ", maxChild='" + maxChild + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", hotelId=" + hotelId +
                ", roomImage='" + roomImage + '\'' +
                '}';
    }
}
