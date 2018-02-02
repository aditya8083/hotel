package com.coviam.entity.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

/**
 * Created by avinashkumar on 31/01/2018 AD.
 */
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequest {

    private String itnId;
    private Double amount;
    private String providerId;
    private String paymentMethod;
    private String customerId;
    private CardDetailsRequest cardDetailsRequest;
    private Boolean overRideFlag;

    public String getItnId() {
        return itnId;
    }

    public void setItnId(String itnId) {
        this.itnId = itnId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CardDetailsRequest getCardDetailsRequest() {
        return cardDetailsRequest;
    }

    public void setCardDetailsRequest(CardDetailsRequest cardDetailsRequest) {
        this.cardDetailsRequest = cardDetailsRequest;
    }

    public Boolean getOverRideFlag() {
        return overRideFlag;
    }

    public void setOverRideFlag(Boolean overRideFlag) {
        this.overRideFlag = overRideFlag;
    }

    public PaymentRequest(){

    }

    public PaymentRequest(String itnId, Double amount, String providerId, String paymentMethod, String customerId, CardDetailsRequest cardDetailsRequest, Boolean overRideFlag) {
        this.itnId = itnId;
        this.amount = amount;
        this.providerId = providerId;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
        this.cardDetailsRequest = cardDetailsRequest;
        this.overRideFlag = overRideFlag;
    }

}
