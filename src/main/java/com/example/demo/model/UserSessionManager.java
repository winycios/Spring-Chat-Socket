package com.example.demo.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Component
public class UserSessionManager {
    private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    public void addUser(String username) {
        onlineUsers.add(username);
    }

    public void addUser(List<String> usernames) {
        onlineUsers.addAll(usernames);
    }

    public void removeUser(String username) {
        onlineUsers.remove(username);
    }
}
