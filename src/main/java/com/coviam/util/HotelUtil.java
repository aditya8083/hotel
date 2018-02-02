package com.coviam.util;

import com.coviam.entity.model.HotelPriceFilter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HotelUtil {


    @SuppressWarnings("serial")
    protected static Map<Integer, Object> priceFilterSet() {
        return Collections.unmodifiableMap(new HashMap<Integer, Object>() {
            {
                put(0, new HotelPriceFilter("1", "1000"));
                put(1, new HotelPriceFilter("1001", "2000"));
                put(2, new HotelPriceFilter("2001", "4000"));
                put(3, new HotelPriceFilter("4001", "8000"));
                put(4, new HotelPriceFilter("8000", "100000"));
            }
        });
    }

    public HotelPriceFilter getPriceMinMaxValue(String filterValue) {
          return (HotelPriceFilter) priceFilterSet().get(Integer.parseInt(filterValue) -1);
    }




}
