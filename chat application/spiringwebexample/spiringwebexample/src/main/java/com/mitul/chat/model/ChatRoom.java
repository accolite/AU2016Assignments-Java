package com.mitul.chat.model;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private int id;
    private List<Message> messages = new ArrayList<Message>();

    public ChatRoom(int id) {
        this.id = id;
    }

    public ChatRoom() {
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
