package com.coviam.entity.model;

import com.coviam.util.Auditable;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="CardDetails")
@Table(name="card_details")
@EntityListeners(AuditingEntityListener.class)
public class CardDetails extends Auditable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "nameOnCard")
    private String nameOnCard;

    @Column(name = "expDate")
    private String expDate;

    @Column(name = "cvv")
    private String cvv;

    @OneToMany(
            mappedBy = "cardDetails",
            cascade = CascadeType.ALL,
            fetch= FetchType.EAGER
    )
    @JsonManagedReference
    private List<Transaction> transactions = new ArrayList<>();

    private CardDetails(Builder builder) {
        setCardNumber(builder.cardNumber);
        setNameOnCard(builder.nameOnCard);
        setExpDate(builder.expDate);
        setCvv(builder.cvv);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public CardDetails(String cardNumber, String nameOnCard, String expDate, String cvv) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
        this.cvv = cvv;
    }
    public CardDetails()
    {

    }

    public static final class Builder {
        private String cardNumber;
        private String nameOnCard;
        private String expDate;
        private String cvv;

        public Builder() {
        }

        public Builder cardNumber(String val) {
            cardNumber = val;
            return this;
        }

        public Builder nameOnCard(String val) {
            nameOnCard = val;
            return this;
        }

        public Builder expDate(String val) {
            expDate = val;
            return this;
        }

        public Builder cvv(String val) {
            cvv = val;
            return this;
        }

        public CardDetails build() {
            return new CardDetails(this);
        }
    }
}
