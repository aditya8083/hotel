package com.coviam.entity.request;

public class HotelSearchRequest {

    private String searchLocation;
    private String checkInDate;
    private String checkOutDate;
    private String noOfNights;
    private String noOfRooms;
    private String filterBy;
    private String filterValue;

    public String getSearchLocation() {
        return searchLocation;
    }

    public void setSearchLocation(String searchLocation) {
        this.searchLocation = searchLocation;
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

    public String getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(String noOfNights) {
        this.noOfNights = noOfNights;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public HotelSearchRequest() {
    }

    public HotelSearchRequest(String searchLocation, String checkInDate, String checkOutDate, String noOfNights, String noOfRooms, String filterBy, String filterValue) {
        this.searchLocation = searchLocation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfNights = noOfNights;
        this.noOfRooms = noOfRooms;
        this.filterBy = filterBy;
        this.filterValue = filterValue;
    }


    @Override
    public String toString() {
        return "HotelSearchRequest{" +
                "searchLocation='" + searchLocation + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", noOfNights='" + noOfNights + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", filterBy='" + filterBy + '\'' +
                ", filterValue='" + filterValue + '\'' +
                '}';
    }
}
