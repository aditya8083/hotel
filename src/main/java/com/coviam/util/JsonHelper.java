package com.coviam.util;

import com.coviam.entity.request.UpdateBookingPaymentRequest;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JsonHelper {

    public JSONObject getJSONObject(UpdateBookingPaymentRequest request) {
        Gson gsonObj = new Gson();
        return new JSONObject(gsonObj.toJson(request));
    }


}
