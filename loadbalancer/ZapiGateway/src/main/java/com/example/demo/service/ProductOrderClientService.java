package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ProductOrderClientService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<String> getProductHello() {
        return webClientBuilder.build()
            .get()
            .uri("http://ZProductService/product/hello")
            .retrieve()
            .bodyToMono(String.class);
    }

    public Mono<String> getOrderHello() {
        return webClientBuilder.build()
            .get()
            .uri("http://ZOrderService/order/hello")
            .retrieve()
            .bodyToMono(String.class);
    }
}
