package com.company.kafkasample.service;

public interface KafkaSenderService {
    String NAME = "kafkasample_KafkaSenderService";

    void sendMessage(String message);

}