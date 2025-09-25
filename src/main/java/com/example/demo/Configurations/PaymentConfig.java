package com.example.demo.Configurations;

import org.springframework.context.annotation.Configuration;

import com.phonepe.sdk.pg.Env;
import com.phonepe.sdk.pg.common.models.response.OrderStatusResponse;
import com.phonepe.sdk.pg.payments.v2.StandardCheckoutClient;
import com.phonepe.sdk.pg.payments.v2.models.request.StandardCheckoutPayRequest;
import com.phonepe.sdk.pg.payments.v2.models.response.StandardCheckoutPayResponse;

@Configuration
public class PaymentConfig {
    String clientId = "UATNAMANFINLEASE_2507231";
    String clientSecret = "NWM4YTQ0YzQtZjA1NC00YmRiLWE5OTUtNWMxODY2YjU1NTdk";
    Integer clientVersion = 1;            
    Env env = Env.SANDBOX;           
    
    StandardCheckoutClient client = StandardCheckoutClient.getInstance(clientId, clientSecret, clientVersion, env);

    public String initiatePayment(String orderId, int orderAmount) {
        String merchantOrderId = orderId;
        long amount = orderAmount*100;
        String redirectUrl = "http://localhost:5173/OrderStatus?id="+orderId;

        StandardCheckoutPayRequest standardCheckoutPayRequest = StandardCheckoutPayRequest.builder()
            .merchantOrderId(merchantOrderId)
            .amount(amount)
            .redirectUrl(redirectUrl)
            .build();

        StandardCheckoutPayResponse standardCheckoutPayResponse = client.pay(standardCheckoutPayRequest);
        String checkoutPageUrl = standardCheckoutPayResponse.getRedirectUrl();
        return checkoutPageUrl;
    }

    public String OrderStatus(String id) {
        String merchantOrderid = id;
        OrderStatusResponse orderStatusResponse = client.getOrderStatus(merchantOrderid);
        return orderStatusResponse.getState();
    }
}
//Test