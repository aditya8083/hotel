package com.coviam.Controller;

import com.coviam.Service.BookingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class bookingController {

   @Autowired
    BookingManager bookingManager;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String doBooking(HttpServletRequest request) {
        System.out.println("do Booking");
        String bookingResult = bookingManager.doBooking(request);
        return bookingResult;
    }
}
