package com.example.demo.controller;


import com.example.demo.model.ChatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/{username}")
    @SendTo("/topic/{username}")
    public ChatMessage sendMessage(@DestinationVariable String username, ChatMessage chatMessage) {
        return new ChatMessage(username, chatMessage.getMessage());
    }
}
