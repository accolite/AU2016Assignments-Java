package com.accolite.restandsoap;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message
{
    private String message;

    private String msgid;

    private String likes;

    private List<Comments> comments;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getMsgid ()
    {
        return msgid;
    }

    public void setMsgid (String msgid)
    {
        this.msgid = msgid;
    }

    public String getLikes ()
    {
        return likes;
    }

    public void setLikes (String likes)
    {
        this.likes = likes;
    }

    
    public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", msgid = "+msgid+", likes = "+likes+", comments = "+comments+"]";
    }
}
				