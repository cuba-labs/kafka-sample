package com.company.kafkasample.web.screens.sender;

import com.company.kafkasample.service.KafkaSenderService;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("kafkasample_MessageSender")
@UiDescriptor("message-sender.xml")
public class MessageSender extends Screen {

    @Inject
    private TextArea<String> messageText;

    @Inject
    private KafkaSenderService kafkaSenderService;

    @Subscribe("sendMsg")
    public void onSendMsg(Action.ActionPerformedEvent event) {
        kafkaSenderService.sendMessage(messageText.getRawValue());
        messageText.setValue("");
    }
}