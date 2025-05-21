package com.example.asrbank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PanService {

    private final WebClient webClient;

    public PanService() {
        this.webClient = WebClient.create("http://localhost:9092"); // Update the base URL as needed
    }

    public String verifyPan(String panNumber) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/verifyPan")
                        .queryParam("pan", panNumber)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Consider using reactive return type (Mono<String>) if your app is reactive
    }
}
