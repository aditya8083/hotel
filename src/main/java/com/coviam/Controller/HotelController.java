package com.coviam.Controller;

import com.coviam.entity.model.Hotel;
import com.coviam.entity.model.RoomType;
import com.coviam.Service.HotelManager;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelManager hotelManager;

    @RequestMapping(value = "/hotel/search", method = RequestMethod.GET)
    public String searchHotel(HttpServletRequest request) {
        System.out.println("searching Hotel for the criteria");
        String searchResult = hotelManager.hotelSearch(request);
        return searchResult;
    }

    @RequestMapping(value = "/hotel/detail", method = RequestMethod.GET)
    public String getHotelDetail(HttpServletRequest request) {
        System.out.println("getting Hotel Details");
        String hotelDetailResult = hotelManager.hotelDetail(request);
        return hotelDetailResult;
    }

    @RequestMapping(
            value = "/saveHotelDetails",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String saveHotelDetails(@RequestBody Hotel hotel) {
        String hotelSaveResponse = hotelManager.saveHotelDetails(hotel);
        return hotelSaveResponse;
    }


    @RequestMapping(
            value = "/saveRoomTypeDetails",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String saveRoomTypeDetails(@RequestBody RoomType roomType) {
        String roomTypeSaveResponse = hotelManager.saveRoomTypeDetails(roomType);
        return roomTypeSaveResponse;
    }


}
