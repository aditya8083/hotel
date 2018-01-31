package com.coviam.Entity.Dao;

import com.coviam.util.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity(name = "HotelDao")
@Table(name = "hotel")
@EntityListeners(AuditingEntityListener.class)
public class HotelDao extends Auditable<String> {

    @Id
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "hotel_id", sequenceName = "hotel_id", allocationSize = 1, initialValue = 1)
    private Long hotelId;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "city")
    private String city;

    @Column(name = "hotel_location")
    private String hotelLocation;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "checkin_time")
    private String checkinTime;

    @Column(name = "checkout_time")
    private String checkoutTime;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "country")
    private String country;

    @Column(name = "star_rating")
    private String starRating;

    @Column(name = "user_rating")
    private String userRating;

    @Column(name = "hotel_image")
    private String hotelImage;


    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

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


    public HotelDao(String hotelName, String city, String hotelLocation, String postCode, String checkinTime, String checkoutTime, String latitude, String longitude, String country, String starRating, String userRating, String hotelImage) {
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

    public HotelDao() {
    }

    @Override
    public String toString() {
        return "HotelDao{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
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
