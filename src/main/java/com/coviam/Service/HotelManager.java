package com.coviam.Service;

import com.coviam.Entity.Dao.HotelDao;
import com.coviam.Entity.model.Hotel;
import com.coviam.repository.HotelRepository;
import com.coviam.util.ConstantsUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelManager {

    @Autowired HotelRepository hotelRepository;
    @Autowired ConstantsUtil constantsUtil;
  //  @Autowired RoomTypeRepository roomTypeRepository;

    public String hotelSearch(HttpServletRequest request) {

        return "";
    }

    public String hotelDetail(HttpServletRequest request) {

        return "";
    }

    public String saveHotelDetails(Hotel hotel) {
        HotelDao hotelDao = new HotelDao(hotel.getHotelName(), hotel.getCity(), hotel.getHotelLocation(), hotel.getPostCode(), hotel.getCheckinTime(), hotel.getCheckoutTime(),
                hotel.getLatitude(), hotel.getLongitude(), hotel.getCountry(), hotel.getStarRating(), hotel.getUserRating(), hotel.getHotelImage());
        HotelDao hotelRes = hotelRepository.save(hotelDao);
        if (!hotelRes.getCity().isEmpty())
            return constantsUtil.SUCCESS;

        return constantsUtil.FAILURE;
    }

  /*  public String saveRoomTypeDetails(RoomType roomType) {
        RoomTypeDao roomTypeDao = new RoomTypeDao(roomType.getRoomName(), roomType.getRoomPrice(), roomType.getNoOfBeds(), roomType.getIsFreeBreakfast(), roomType.getIsFreeWifi(),
                    roomType.getMaxAdult(), roomType.getMaxChild(), roomType.getNoOfRooms(), roomType.getHotelId(), roomType.getRoomImage());
        RoomTypeDao roomTypeRes = roomTypeRepository.save(roomTypeDao);
        if (roomTypeRes.getHotelId() > 0)
            return constantsUtil.SUCCESS;

        return constantsUtil.FAILURE;
    }*/
}
