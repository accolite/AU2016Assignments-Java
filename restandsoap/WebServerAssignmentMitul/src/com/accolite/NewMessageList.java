package com.accolite;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Mitul Kapoor on 7/23/2016.
 */
@XmlRootElement
public class NewMessageList {
    List<NewMessage> newMessageList;

    public List<NewMessage> getNewMessageList() {
        return newMessageList;
    }

    public void setNewMessageList(List<NewMessage> newMessageList) {
        this.newMessageList = newMessageList;
    }
}
