package com.coviam.Service;

import com.coviam.entity.model.CardDetails;
import com.coviam.entity.model.ProviderConfig;
import com.coviam.entity.model.Transaction;
import com.coviam.entity.request.PaymentRequest;
import com.coviam.entity.request.UpdateBookingPaymentRequest;
import com.coviam.entity.response.PaymentResponse;
import com.coviam.entity.response.ProcessPaymentResponse;
import com.coviam.repository.CardDetailsRepository;
import com.coviam.repository.TransactionRepository;
import com.coviam.util.HttpUtility;
import com.coviam.util.JsonHelper;
import com.coviam.util.RandomGenerator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties(prefix = "endpoint")
public class TransactionService {

    @Value("${endpoint.paymentSuccess}")
    private String paymentSuccess;
    @Value("${endpoint.paymentError}")
    private String paymentError;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CardDetailsRepository cardDetailsRepository;
    @Autowired
    RandomGenerator randomGenerator;
    @Autowired
    ProviderService providerService;
    @Autowired
    CardPaymentServiceImpl cardPaymentService;
    @Autowired
    JsonHelper jsonHelper;

    public ProcessPaymentResponse processPayment(PaymentRequest paymentRequest) {

        String itnId = paymentRequest.getItnId();
        Double amount = paymentRequest.getAmount();
        String providerId = paymentRequest.getProviderId();
        String paymentMethod = paymentRequest.getPaymentMethod();
        String customerId = paymentRequest.getCustomerId();
        CardDetails cardDetails = new CardDetails.Builder().cardNumber(paymentRequest.getCardDetailsRequest().getCardNumber()).nameOnCard(paymentRequest.getCardDetailsRequest().getNameOnCard())
                .expDate(paymentRequest.getCardDetailsRequest().getExpDate()).cvv(paymentRequest.getCardDetailsRequest().getCvv()).build();
        Boolean overRideFlag = paymentRequest.getOverRideFlag();
        System.out.println("Amount" + amount);
        ProcessPaymentResponse processPaymentResponse;
        ProviderConfig providerConfig = providerService.getProviderConfig(Long.valueOf(providerId));
        PaymentResponse paymentResponse = cardPaymentService.pay(cardDetails, overRideFlag, providerConfig);
        Transaction.Status paymentStatus;
        final String uri;
        if (paymentResponse.getSuccess()) {
            paymentStatus = Transaction.Status.success;
            uri = paymentSuccess;
        } else {
            paymentStatus = Transaction.Status.deferred;
            uri = paymentError;
        }
        CardDetails details = new CardDetails(paymentRequest.getCardDetailsRequest().getCardNumber(), paymentRequest.getCardDetailsRequest().getNameOnCard(), paymentRequest.getCardDetailsRequest().getExpDate(), paymentRequest.getCardDetailsRequest().getCvv());
        Transaction newTransaction = new Transaction.Builder().txnId(randomGenerator.generateRandomString()).paymentMethod(paymentMethod).amount(amount).customerId(customerId).itnId(itnId).paymentStatus(paymentStatus).providerId(providerId).build();
        CardDetails savedCardDetails = cardDetailsRepository.save(cardDetails);
        Transaction savedTransaction = transactionRepository.save(newTransaction);
        UpdateBookingPaymentRequest requestObj = new UpdateBookingPaymentRequest(savedTransaction.getItnId(), savedTransaction.getTxnId());
        if (paymentResponse.getSuccess()) {
            JSONObject jsonResponse = new JSONObject(HttpUtility.service_AppJSON(uri, 1, jsonHelper.getJSONObject(requestObj)));

            if (jsonResponse.getBoolean("success") == true) {
                processPaymentResponse = new ProcessPaymentResponse(true, jsonResponse.getInt("status"));

            } else {
                processPaymentResponse = new ProcessPaymentResponse(false, jsonResponse.getInt("status"), "Failed While Updating Booking");

            }
        } else {
            processPaymentResponse = new ProcessPaymentResponse(paymentResponse.getSuccess(), paymentResponse.getStatus(), paymentResponse.getErrorMsg());
        }
        return processPaymentResponse;
    }
}
