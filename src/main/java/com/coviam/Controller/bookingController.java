package com.coviam.Controller;

import com.coviam.entity.model.Booking;
import com.coviam.entity.request.CreateBookingRequest;
import com.coviam.entity.request.UpdateBookingPaymentRequest;
import com.coviam.entity.response.UpdateBookingResponse;
import com.coviam.Service.BookingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class bookingController {

    @Autowired
    BookingManager bookingManager;


    @RequestMapping(
            value = "/createBooking",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Booking createBooking(@RequestBody CreateBookingRequest request) {
        Booking newBooking = bookingManager.createBooking(request);
        return newBooking;
    }


    @RequestMapping(
            value = "/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Booking getBooking(@PathVariable("id") String id) {
        return bookingManager.getBooking(id);
    }

    @RequestMapping(
            value = "/updateBookingPaymentSuccessful",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentSuccessful(@RequestBody UpdateBookingPaymentRequest request) {
        UpdateBookingResponse response = bookingManager.updateBookingPaymentSuccessful(request);
        return response;
    }

    @RequestMapping(
            value = "/updateBookingPaymentError",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentError(@RequestBody UpdateBookingPaymentRequest request) {
        UpdateBookingResponse response = bookingManager.updateBookingPaymentError(request);
        return response;
    }

    @RequestMapping(
            value = "/updateBookingPaymentCancel",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UpdateBookingResponse updateBookingPaymentCancel(@RequestBody UpdateBookingPaymentRequest request) {
        UpdateBookingResponse response = bookingManager.updateBookingPaymentCancel(request);
        return response;
    }

    @RequestMapping(value = "/booking/createBooking", method = RequestMethod.POST)
    public String createPartialBooking(@RequestBody Booking booking) {
        System.out.println("creating partial Booking ");
        String partialBookingResponse = bookingManager.createBooking(booking);
        System.out.println(partialBookingResponse);
        return partialBookingResponse;

    }
}
