package com.coviam.Service;

import com.coviam.Entity.Dao.HotelDao;
import com.coviam.Entity.Dao.RoomTypeDao;
import com.coviam.Entity.model.Hotel;
import com.coviam.Entity.model.HotelPriceFilter;
import com.coviam.Entity.model.RoomType;
import com.coviam.Entity.request.HotelSearchRequest;
import com.coviam.repository.HotelRepository;
import com.coviam.repository.RoomTypeRepository;
import com.coviam.util.ConstantsUtil;
import com.coviam.util.HotelConstants;
import com.coviam.util.HotelUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class HotelManager {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ConstantsUtil constantsUtil;
    @Autowired
    RoomTypeRepository roomTypeRepository;
    @Autowired
    HotelConstants hotelConstants;
    @Autowired
    HotelUtil hotelUtil;
  /*  @PersistenceContext EntityManager em;*/

    public String hotelSearch(HttpServletRequest request) {
        JSONObject hotelSearchResult = new JSONObject();
        List<HotelDao> hotelResults = new ArrayList<>();
        if(StringUtils.isBlank(request.getParameter("filterBy"))) {
            hotelResults = hotelRepository.findByCity(request.getParameter("searchLocation"));
        }else{
            hotelResults = getFilteredHotelResults(request);
        }
        hotelSearchResult.put("hotel_result", hotelResults);
        return hotelSearchResult.toString();
    }

    private List<HotelDao> getFilteredHotelResults(HttpServletRequest request) {
        List<HotelDao> hotelResults = new ArrayList<>();
        if(request.getParameter("filterBy").equalsIgnoreCase(hotelConstants.PRICE)){
            HotelPriceFilter hotelPriceFilter = hotelUtil.getPriceMinMaxValue(request.getParameter("filterValue"));
            hotelResults = getFilteredHotelBasedOnPrice(hotelPriceFilter, request.getParameter("searchLocation"));
           // hotelResults = hotelRepository.findByPriceRating(request.getParameter("searchLocation"), hotelPriceFilter.getMin(), hotelPriceFilter.getMax());
        }else if(request.getParameter("filterBy").equalsIgnoreCase(hotelConstants.RATING)){
            hotelResults = hotelRepository.findByStarRating(request.getParameter("searchLocation"), request.getParameter("filterValue"));
        }
        return hotelResults;
    }

    private List<HotelDao> getFilteredHotelBasedOnPrice(HotelPriceFilter hotelPriceFilter, String searchLocation) {
        List<HotelDao> hotelResultList = new ArrayList<>();
        List<Long> searchedHotelIds = hotelRepository.findHotelIdByHotelLocation(searchLocation);
        List<Long> filteredHotelIdsBasedOnPrice = roomTypeRepository.findHotelIdByPriceFilter(searchedHotelIds, hotelPriceFilter.getMin(), hotelPriceFilter.getMax());
        List<Long> filteredHotelIdsWithoutDuplicates = filteredHotelIdsBasedOnPrice.stream()
                                                      .distinct()
                                                      .collect(Collectors.toList());
        hotelResultList = hotelRepository.findHotelByHotelIds(filteredHotelIdsWithoutDuplicates);
        return hotelResultList;
    }

   /* @Transactional
    private List<HotelDao> getFilteredHotelBasedOnPrice(HotelPriceFilter hotelPriceFilter, String searchLocation) {
        List<HotelDao> hotelResultList = new ArrayList<>();
        try {
          //  EntityManagerFactory emf = Persistence.createEntityManagerFactory("HotelManager");
          //  EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT h FROM HotelDao h JOIN RoomTypeDao r ON h.hotelId = r.hotelId ");
            query.setParameter("city", searchLocation);
            hotelResultList = (List<HotelDao>) query.getResultList();
         //   em.getTransaction().commit();
            em.close();
        }catch(Exception e){
            System.out.println("Getting Exception in Getting the Hotel Search Results");
        }
        return hotelResultList;
    }*/

    public String hotelDetail(HttpServletRequest request) {
        JSONObject hotelDetailsObj = new JSONObject();
        Long hotelId = Long.parseLong(request.getParameter("hotelId"));
        HotelDao hotelResult = hotelRepository.findHotelById(hotelId);
        List<RoomTypeDao> roomDetails = roomTypeRepository.findRoomsByHotelId(hotelId);
        hotelDetailsObj.put("hotelDetail",new JSONObject(hotelResult) );
        hotelDetailsObj.put("roomDetails", roomDetails);
        return hotelDetailsObj.toString();
    }

    public String saveHotelDetails(Hotel hotel) {
        HotelDao hotelDao = new HotelDao(hotel.getHotelName(), hotel.getCity(), hotel.getHotelLocation(), hotel.getPostCode(), hotel.getCheckinTime(), hotel.getCheckoutTime(),
                hotel.getLatitude(), hotel.getLongitude(), hotel.getCountry(), hotel.getStarRating(), hotel.getUserRating(), hotel.getHotelImage());
        HotelDao hotelRes = hotelRepository.save(hotelDao);
        if (!hotelRes.getCity().isEmpty())
            return constantsUtil.SUCCESS;

        return constantsUtil.FAILURE;
    }

    public String saveRoomTypeDetails(RoomType roomType) {
        RoomTypeDao roomTypeDao = new RoomTypeDao(roomType.getRoomName(), roomType.getRoomPrice(), roomType.getNoOfBeds(), roomType.getIsFreeBreakfast(), roomType.getIsFreeWifi(),
                roomType.getMaxAdult(), roomType.getMaxChild(), roomType.getNoOfRooms(), roomType.getHotelId(), roomType.getRoomImage());
        RoomTypeDao roomTypeRes = roomTypeRepository.save(roomTypeDao);
        if (roomTypeRes.getHotelId() > 0)
            return constantsUtil.SUCCESS;

        return constantsUtil.FAILURE;
    }
}
