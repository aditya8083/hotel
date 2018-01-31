package com.coviam.Entity.model;

public class HotelRoomAvailability {

    private String hotelId;
    private String roomTypeId;
    private String checkInDate;
    private String checkOutDate;


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

    public HotelRoomAvailability() {
    }

    public HotelRoomAvailability(String hotelId, String roomTypeId, String checkInDate, String checkOutDate) {
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "HotelRoomAvailability{" +
                "hotelId='" + hotelId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                '}';
    }
}
