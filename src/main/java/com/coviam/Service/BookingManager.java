package com.coviam.Service;


import com.coviam.entity.model.Booking;
import com.coviam.entity.request.CreateBookingRequest;
import com.coviam.entity.request.UpdateBookingPaymentRequest;
import com.coviam.entity.response.UpdateBookingResponse;
import com.coviam.repository.BookingRepository;
import com.coviam.repository.BookingUserDetailsRepository;
import com.coviam.util.HttpUtility;
import com.coviam.util.RandomGenerator;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "endpoint")
public class BookingManager {

    @Value("${endpoint.booking}")
    private String flightBooking;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    BookingUserDetailsRepository bookingUserDetailsRepository;
    @Autowired
    RandomGenerator randomGenerator;


    public Booking getBooking(String booking_reference){
        return bookingRepository.findByBookingReference(booking_reference);
    }

    public Booking createBooking(CreateBookingRequest request){
        Booking newBooking = new Booking(request.getCustomer_id(), randomGenerator.generateRandomString(),request.getSuper_pnr(), Booking.Status.pending,"",Booking.Status.pending,request.getBooking_type(),request.getBooking_source(),request.getBooking_phone_number(),request.getBooking_email());
        newBooking.setBookingUserDetails(request.getUser_details());
        Booking newBookingResponse = bookingRepository.save(newBooking);
        return newBookingResponse;
    }

    public UpdateBookingResponse updateBookingPaymentSuccessful(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());

        current_booking.setBooking_status(Booking.Status.successful);
        current_booking.setPayment_status(Booking.Status.successful);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
            response = new UpdateBookingResponse(true,200);
        }else{
            response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;
    }

    public UpdateBookingResponse updateBookingPaymentError(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());

        current_booking.setBooking_status(Booking.Status.deferred);
        current_booking.setPayment_status(Booking.Status.deferred);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
            response = new UpdateBookingResponse(true,200);
        }else{
            response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;
    }

    public UpdateBookingResponse updateBookingPaymentCancel(UpdateBookingPaymentRequest request){
        Booking current_booking = this.getBooking(request.getBooking_reference());
        current_booking.setBooking_status(Booking.Status.cancelled);
        current_booking.setPayment_status(Booking.Status.cancelled);
        current_booking.setPayment_id(request.getPayment_id());

        Booking saved_booking = bookingRepository.save(current_booking);

        UpdateBookingResponse response;
        if(saved_booking != null){
            response = new UpdateBookingResponse(true,200);
        }else{
            response = new UpdateBookingResponse(false,201,"Update Booking Failed");
        }
        return response;

    }


    public String createBooking(Booking booking) {
        String bookingResponse = "";
        try {
            System.out.println("Booking Params : ==========" + booking);
            bookingResponse = HttpUtility.service_AppJSON(flightBooking, HttpUtility.METHOD_POST, getJSONObject(booking));
        } catch (Exception e) {
            System.out.println("Exception in making the partial Booking");
        }
        return bookingResponse;
    }

    private JSONObject getJSONObject(Booking booking) {
        Gson gsonObj = new Gson();
        return new JSONObject(gsonObj.toJson(booking));
    }

}
