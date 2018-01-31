package com.coviam.Controller;


import com.coviam.Service.PaymentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class paymentController {

    @Autowired
    PaymentManager paymentManager;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String dpPayment(HttpServletRequest request) {
        System.out.println("do Payment");
        String paymentResult = paymentManager.doPayment(request);
        return paymentResult;
    }
}
