package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GatewayConfig {

    @Bean
    @LoadBalanced
    public RouteLocator customRoute(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("ZProductService", r -> r.path("/product/**")
                .filters(f -> f.circuitBreaker(config -> config
                    .setName("ZProductServiceCircuitBreaker")
                    .setFallbackUri("forward:/fallback/product")))
                .uri("lb://ZProductService"))

            .route("ZOrderService", r -> r.path("/order/**")
                .filters(f -> f.circuitBreaker(config -> config
                    .setName("ZOrderServiceCircuitBreaker")
                    .setFallbackUri("forward:/fallback/order")))
                .uri("lb://ZOrderService"))
            .build();
    }


    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}
