package com.example.asrbank.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class AadhaarService {

	WebClient webClient = WebClient.create("http://localhost:9091"); // No builder needed

    public String verifyAadhaar(String aadhaarNumber) {
        return webClient.post()
        	    .uri(uriBuilder -> uriBuilder
        	            .path("/api/verifyAadhaar")
        	            .queryParam("aN", aadhaarNumber)
        	            .build())
        	        .retrieve()
        	        .bodyToMono(String.class) // or the expected class
        	        .block();
    }
}

