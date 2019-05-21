package com.example.springwebsockt;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * creating a WebSocket server is as simple as implementing WebSocketHandler
 * or,more likely, extending either TextWebSocketHandler or BinaryWebSocketHandler.
 */
public class MyHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession webSocketSession, TextMessage message) {
        try {
            System.out.println(message);
            webSocketSession.sendMessage(new TextMessage(message.getPayload()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
