package com.company.kafkasample.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "KAFKASAMPLE_KAFKA_MESSAGE")
@Entity(name = "kafkasample_KafkaMessage")
@NamePattern("%s:%s|kafkaID,content")
public class KafkaMessage extends StandardEntity {
    private static final long serialVersionUID = 7256213658664044910L;

    @Column(name = "KAFKA_ID")
    private Integer kafkaID;

    @Column(name = "CONTENT")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getKafkaID() {
        return kafkaID;
    }

    public void setKafkaID(Integer kafkaID) {
        this.kafkaID = kafkaID;
    }

}