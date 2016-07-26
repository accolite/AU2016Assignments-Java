package com.mitul.chat.controller;

import com.mitul.chat.model.ChatManager;
import com.mitul.chat.model.Message;
import com.mitul.chat.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChatController {

    @RequestMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest servletRequest
    ) throws Exception {
        User user = ChatManager.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            servletRequest.getSession().setAttribute("user", user);
        } else {
            logout(servletRequest);
        }

        return "chat";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest servletRequest) throws Exception {
        servletRequest.getSession().removeAttribute("user");
        servletRequest.getSession().removeAttribute("banned_list");
        return "chat";
    }
/*
    @RequestMapping(value = "/activeUsers")
    public ModelAndView activeUsers() throws Exception {
        ModelAndView mav = new ModelAndView("Login");
        ChatManager.getRegisteredUsers();
        return mav;
    }*/

    @RequestMapping(value = "/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password) throws Exception {
        ChatManager.getRegisteredUsers().add(new User(username, password));
        return "chat";
    }

    @RequestMapping(value = "/chat")
    public String register(   HttpServletRequest servletRequest) throws Exception {
        servletRequest.setAttribute("banned_list",ChatManager.getBannedWords());
        return "chat";
    }

    @RequestMapping(value = "/banned")
    public String banned(@RequestParam("message") String message) throws Exception {
        ChatManager.getBannedWords().addAll(Arrays.asList(message.split(",")));
        return "chat";
    }

    @RequestMapping(value = "/send")
    public String activeUsers(@RequestParam("message") String message, HttpServletRequest servletRequest) throws Exception {
        User user = (User) servletRequest.getSession().getAttribute("user");

        for (String s : ChatManager.getBannedWords()) {
            message = message.replace(s, "@banned@");
        }
        if (user != null) {
            ChatManager.getChatRooms().get(0).getMessages().add(new Message(message, new Date(), user));
        }
        return "chat";
    }
}
