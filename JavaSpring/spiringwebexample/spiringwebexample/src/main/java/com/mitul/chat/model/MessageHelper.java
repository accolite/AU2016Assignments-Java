package com.mitul.chat.model;

import java.util.Date;

/**
 * Created by Mitul Kapoor on 7/27/2016.
 */
public class MessageHelper {
    private String user;
    private Date date;
    private String message;

    public void setUser(String user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
