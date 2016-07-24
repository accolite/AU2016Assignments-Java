package com.myMessanger;
public class Message
{
    private String message;

    private String message_id;

    private String user_id;
    
    public String time;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getMessage_id ()
    {
        return message_id;
    }

    public void setMessage_id (String message_id)
    {
        this.message_id = message_id;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setTime(String time )
    {
    	this.time=time;
    }
    public String getTime()
    {
    	return this.time;
    }
    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }
   

    @Override
    public String toString()
    {
        return " message = "+message+", message_id = "+message_id+", user_id = "+user_id;
    }
}