package com.coviam.Service;

import com.coviam.entity.model.CardDetails;
import com.coviam.entity.model.ProviderConfig;
import com.coviam.entity.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class CardPaymentServiceImpl implements CardPaymentService{

    @Override
    public PaymentResponse pay(CardDetails cardDetails, Boolean overRideFlag, ProviderConfig providerConfig) {
        PaymentResponse paymentResponse;
        if(overRideFlag){
            paymentResponse = new PaymentResponse(true,200);
        }else{
            paymentResponse = new PaymentResponse(false,201, "Payment Failure");
        }
        return paymentResponse;
    }
}
