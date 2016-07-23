package com.accolite;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mitul Kapoor on 7/22/2016.
 */
@XmlRootElement
public class Comment {

    private int messageID;
    private int commentID;
    private int personPostingID;
    private String comment;

    public Comment(){
        super();
    }

    public Comment(int commentID,String comment){
        this.commentID = commentID;
        this.comment = comment;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setPersonPostingID(int personPostingID) {
        this.personPostingID = personPostingID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMessageID() {
        return messageID;
    }

    public int getCommentID() {
        return commentID;
    }

    public int getPersonPostingID() {
        return personPostingID;
    }

    public String getComment() {
        return comment;
    }
}
