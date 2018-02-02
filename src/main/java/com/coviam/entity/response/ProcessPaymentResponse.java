package com.coviam.entity.response;

import com.coviam.entity.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class ProcessPaymentResponse {
    private boolean success;

    private int status;

    private String errorMessage;

    private Transaction transaction;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public ProcessPaymentResponse() {
    }

    public ProcessPaymentResponse(boolean success, int status) {
        this.success = success;
        this.status = status;
    }

    public ProcessPaymentResponse(boolean success, int status, String errorMessage) {
        this.success = success;
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ProcessPaymentResponse(boolean success, int status, Transaction transaction) {
        this.success = success;
        this.status = status;
        this.transaction = transaction;
    }
}
