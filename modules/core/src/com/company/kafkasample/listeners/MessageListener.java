package com.company.kafkasample.listeners;

import com.company.kafkasample.entity.KafkaMessage;
import com.haulmont.cuba.core.global.DataManager;
import org.slf4j.Logger;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@DependsOn("consumerFactory")
public class MessageListener {

    @Inject
    private Logger log;

    @Inject
    private DataManager dataManager;

    @KafkaListener(id = "sample-kafka", topics = "users")
    public void listen1(String foo, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) int id) {
        log.info("Received: {}:{}", id, foo);
        KafkaMessage kafkaMessage = dataManager.create(KafkaMessage.class);
        kafkaMessage.setKafkaID(id);
        kafkaMessage.setContent(foo);
        dataManager.commit(kafkaMessage);
        log.info("Saved: {}:{}", id, foo);
    }


}
