package com.harryseong.templatemicroservice.controller;

import com.harryseong.templatemicroservice.domain.Message;
import com.harryseong.templatemicroservice.domain.OutputMessage;
import com.harryseong.templatemicroservice.utils.StringUtils;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatControllerV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatControllerV1.class);

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(@Payload final Message message) throws Exception {

        LOGGER.info(String.format("Received message: %s", message));
        final String time = StringUtils.getCurrentTimeStamp();
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
