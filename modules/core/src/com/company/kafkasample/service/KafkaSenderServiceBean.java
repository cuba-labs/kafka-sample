package com.company.kafkasample.service;

import com.haulmont.cuba.core.app.UniqueNumbersService;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.inject.Inject;

@Service(KafkaSenderService.NAME)
public class KafkaSenderServiceBean implements KafkaSenderService {

    @Inject
    private Logger log;

    @Inject
    private KafkaTemplate<Integer, String> template;

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Override
    public void sendMessage(String message) {
        log.info("Sending {} using Kafka", message);
        long id = uniqueNumbersService.getNextNumber("users");
        ListenableFuture<SendResult<Integer, String>> send = template.send("users", (int) id, message);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
               log.info("Failed to send message {}, error {}", message, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                log.info("Message {} sent", message);
            }
        });
    }
}