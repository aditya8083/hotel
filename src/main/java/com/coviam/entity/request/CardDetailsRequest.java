package com.coviam.entity.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDetailsRequest {

    private String cardNumber;
    private String nameOnCard;
    private String expDate;
    private String cvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CardDetailsRequest(){

    }

    public CardDetailsRequest(String cardNumber, String nameOnCard, String expDate, String cvv) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
        this.cvv = cvv;
    }
}
