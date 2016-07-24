package com.myMessanger;
public class Likes
{
    private String user_id;

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [user_id = "+user_id+"]";
    }
}