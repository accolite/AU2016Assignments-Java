package com.au.proma.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.proma.dao.UserDao;
import com.au.proma.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Boolean addUser(User user) {
		// TODO Auto-generated method stub
		
		String pass=user.getUserpassword();
		try{
		MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        //System.out.println( sb.toString());
        user.setUserpassword(sb.toString());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int no_of_records_updated = userDao.addUser(user);
		if(no_of_records_updated > 0)
			return true;
		else {
			return false;
		}
	}

}
