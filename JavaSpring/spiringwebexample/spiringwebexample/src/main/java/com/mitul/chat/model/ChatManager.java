package com.mitul.chat.model;

import java.util.ArrayList;
import java.util.List;


public class ChatManager {
    private static List<User> registeredUsers = new ArrayList<User>();
    private static List<ChatRoom> chatRooms = new ArrayList<ChatRoom>();
    private static List<String> bannedWords = new ArrayList<String>();


    static {
        chatRooms.add(new ChatRoom(1));
    }

    public static List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public static void setRegisteredUsers(List<User> registeredUsers) {
        ChatManager.registeredUsers = registeredUsers;
    }

    public static List<ChatRoom> getChatRooms() {
        return chatRooms;
    }

    public static void setChatRooms(List<ChatRoom> chatRooms) {
        ChatManager.chatRooms = chatRooms;
    }

    public static User getUser(String username) {
        for (User registeredUser : registeredUsers) {
            if (registeredUser.getUsername().equalsIgnoreCase(username)) {
                return registeredUser;
            }
        }
        return null;
    }

    public static List<String> getBannedWords() {
        return bannedWords;
    }

    public static void setBannedWords(List<String> bannedWords) {
        ChatManager.bannedWords = bannedWords;
    }
}
