package com.example.demo.controller;

import com.example.demo.model.ChatMessage;
import com.example.demo.model.UserSessionManager;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WebSocketController {

    private final UserSessionManager sessionManager;
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(UserSessionManager sessionManager, SimpMessagingTemplate messagingTemplate) {
        this.sessionManager = sessionManager;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/user/online")
    public void userOnline(Map<String, String> user) {
        sessionManager.addUser(user.get("username"));
        messagingTemplate.convertAndSend("/topic/users", sessionManager.getOnlineUsers());
    }

    @MessageMapping("/user/offline")
    public void userOffline(Map<String, String> user) {
        sessionManager.removeUser(user.get("username"));
        messagingTemplate.convertAndSend("/topic/users", sessionManager.getOnlineUsers());
    }

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessage sendMessage(@DestinationVariable String roomId, ChatMessage chatMessage) {
        return new ChatMessage(chatMessage.getMessage(), chatMessage.getUserId());
    }
}
