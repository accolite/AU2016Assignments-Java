package com.accolite;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
@XmlRootElement
public class Likes {

    private int personLikeID;
    private int messageID;
    private int likeID;

    public Likes(){ super();}

    public Likes(int messageID){
        this.messageID = messageID;
    }

    public void setPersonLikeID(int personLikeID) {
        this.personLikeID = personLikeID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getPersonLikeID() {
        return personLikeID;
    }

    public int getMessageID() {
        return messageID;
    }

    public int getLikeID() {
        return likeID;
    }

    public void setLikeID(int likeID) {
        this.likeID = likeID;
    }
}
