package com.coviam.Controller;


import com.coviam.Service.ProviderService;
import com.coviam.Service.TransactionService;
import com.coviam.entity.model.ProviderConfig;
import com.coviam.entity.request.PaymentRequest;
import com.coviam.entity.response.ProcessPaymentResponse;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class paymentController {

    @Autowired
    ProviderService providerService;

    @Autowired
    TransactionService transactionService;

    @RequestMapping(
            value = "/provider/createProvider",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void createProvider(@RequestBody ObjectNode json) {
        providerService.createProvider(json.get("providerName").asText(),json.get("providerUrl").asText(),json.get("providerCallbackUrl").asText() , json.get("providerCredentialKey1").asText(),json.get("providerCredentialKey2").asText(), ProviderConfig.Status.active);
    }


    @RequestMapping(
            value = "/provider/get/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProviderConfig getProvider(@PathVariable("id") Long id) {
        return providerService.getProviderConfig(id);
    }

    @RequestMapping(
            value = "/doPayment",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ProcessPaymentResponse makePayment(@RequestBody PaymentRequest paymentRequest) {
        ProcessPaymentResponse paymentResponse=null;
        try {
            if(paymentRequest!=null){
                paymentResponse=transactionService.processPayment(paymentRequest);
            }else {
                System.out.println("request null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return paymentResponse;
    }
}
