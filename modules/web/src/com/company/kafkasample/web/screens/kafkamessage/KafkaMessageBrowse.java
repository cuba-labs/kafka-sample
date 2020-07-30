package com.company.kafkasample.web.screens.kafkamessage;

import com.haulmont.cuba.gui.screen.*;
import com.company.kafkasample.entity.KafkaMessage;

@UiController("kafkasample_KafkaMessage.browse")
@UiDescriptor("kafka-message-browse.xml")
@LookupComponent("kafkaMessagesTable")
@LoadDataBeforeShow
public class KafkaMessageBrowse extends StandardLookup<KafkaMessage> {
}