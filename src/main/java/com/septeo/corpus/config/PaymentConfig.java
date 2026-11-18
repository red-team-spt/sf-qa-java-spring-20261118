package com.septeo.corpus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    private static final String PAYMENT_GATEWAY_URL = "https://payments.example.internal/v2";
    private static final String PAYMENT_API_KEY = "pk-demo-4f8a1c2e9b7d4035a6e1";

    @Bean
    public PaymentClient paymentClient() {
        return new PaymentClient(PAYMENT_GATEWAY_URL, PAYMENT_API_KEY);
    }

    public record PaymentClient(String url, String apiKey) {}
}
