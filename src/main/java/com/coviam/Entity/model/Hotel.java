package com.coviam.Entity.model;

public class Hotel {
    private String hotelName;
    private String city;
    private String hotelLocation;
    private String postCode;
    private String checkinTime;
    private String checkoutTime;
    private String latitude;
    private String longitude;
    private String country;
    private String starRating;
    private String userRating;
    private String hotelImage;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }


    public Hotel() {
    }

    public Hotel(String hotelName, String city, String hotelLocation, String postCode, String checkinTime, String checkoutTime, String latitude, String longitude, String country, String starRating, String userRating, String hotelImage) {
        this.hotelName = hotelName;
        this.city = city;
        this.hotelLocation = hotelLocation;
        this.postCode = postCode;
        this.checkinTime = checkinTime;
        this.checkoutTime = checkoutTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.starRating = starRating;
        this.userRating = userRating;
        this.hotelImage = hotelImage;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", city='" + city + '\'' +
                ", hotelLocation='" + hotelLocation + '\'' +
                ", postCode='" + postCode + '\'' +
                ", checkinTime='" + checkinTime + '\'' +
                ", checkoutTime='" + checkoutTime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", country='" + country + '\'' +
                ", starRating='" + starRating + '\'' +
                ", userRating='" + userRating + '\'' +
                ", hotelImage='" + hotelImage + '\'' +
                '}';
    }
}
