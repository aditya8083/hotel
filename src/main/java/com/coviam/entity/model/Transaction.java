package com.coviam.entity.model;

import com.coviam.util.Auditable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name="Transaction")
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class Transaction  extends Auditable<String> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "txnId")
    private String txnId;

    @Column(name = "itnId")
    private String itnId;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "providerId")
    private String providerId;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    private Transaction(Builder builder) {
        setTxnId(builder.txnId);
        setItnId(builder.itnId);
        setAmount(builder.amount);
        setProviderId(builder.providerId);
        setPaymentMethod(builder.paymentMethod);
        setPaymentStatus(builder.paymentStatus);
        setCustomerId(builder.customerId);
        setCardDetails(builder.cardDetails);
    }

    public static enum Status {success, pending, deferred, cancelled};

    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private Status paymentStatus = Status.pending;

    @Column(name="customerId")
    private String customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardDetails_id")
    @JsonBackReference
    private CardDetails cardDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

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

    public Status getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Status paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }

    public Transaction(String txnId, String itnId, Double amount, String providerId, String paymentMethod, Status paymentStatus, String customerId,CardDetails cardDetails) {
        this.txnId = txnId;
        this.itnId = itnId;
        this.amount = amount;
        this.providerId = providerId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.customerId = customerId;
        this.cardDetails = cardDetails;
    }

    public Transaction(){

    }

    public static final class Builder {
        private String txnId;
        private String itnId;
        private Double amount;
        private String providerId;
        private String paymentMethod;
        private Status paymentStatus;
        private String customerId;
        private CardDetails cardDetails;

        public Builder() {
        }

        public Builder txnId(String val) {
            txnId = val;
            return this;
        }

        public Builder itnId(String val) {
            itnId = val;
            return this;
        }

        public Builder amount(Double val) {
            amount = val;
            return this;
        }

        public Builder providerId(String val) {
            providerId = val;
            return this;
        }

        public Builder paymentMethod(String val) {
            paymentMethod = val;
            return this;
        }

        public Builder paymentStatus(Status val) {
            paymentStatus = val;
            return this;
        }

        public Builder customerId(String val) {
            customerId = val;
            return this;
        }

        public Builder cardDetails(CardDetails val) {
            cardDetails = val;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
