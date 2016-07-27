package com.service;
import java.util.ArrayList;

import com.dao.ChatBoxDao;
public class ChatBoxSer 
{
	ChatBoxDao cd;
	public boolean reg(String uname,String pwd)
	{
		return cd.reg(uname,pwd);
	}
	public boolean login(String uname,String pwd)
	{
		return cd.login(uname,pwd);
	}
	public boolean insertmsg(String uname,String msg)
	{
		return cd.insertmsg(uname,msg);
	}
	public ArrayList<String> getmsg()
	{
		return cd.getmsg();
	}
}
