package com.coviam.Service;

import com.coviam.entity.model.CardDetails;
import com.coviam.entity.model.ProviderConfig;
import com.coviam.entity.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public interface CardPaymentService {

    PaymentResponse pay(CardDetails cardDetails, Boolean overRideFlag, ProviderConfig providerConfig);

}
