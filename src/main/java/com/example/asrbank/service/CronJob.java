package com.example.asrbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.rmi.server.UID;
import java.util.Random;

@Service
public class CronJob {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @Scheduled(fixedDelay = 6000)
    public String send() {

        int i = new Random().nextInt();
        String message = "Srinadh :"+i;

        kafkaProducerService.sendMessage(message);
        return message;
    }
}
