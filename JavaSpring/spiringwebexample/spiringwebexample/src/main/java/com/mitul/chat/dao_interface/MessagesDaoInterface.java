package com.mitul.chat.dao_interface;

import com.mitul.chat.model.Message;
import com.mitul.chat.model.MessageHelper;

import java.util.Date;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/27/2016.
 */
public interface MessagesDaoInterface  {

    public void insertMessage(String message,Date date,String user);
    public List<MessageHelper> getAllMessages();
}
