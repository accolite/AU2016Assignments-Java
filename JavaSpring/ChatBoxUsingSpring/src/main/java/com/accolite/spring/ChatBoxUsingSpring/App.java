/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Sachin Gupta

* ***************************************************************************

*/
package com.accolite.spring.ChatBoxUsingSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * Hello world!.
 */
public class App 
{
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args )
    {
    	UserInfo userObj=new UserInfo();
    	userObj.setUserName("sachin");
    	userObj.setUserPassword("password");
    	

    	/*RegisterUser registerObj= new ClassPathXmlApplicationContext("databaseAccess.xml").getBean(RegisterUser.class);
    	registerObj.addUser(userObj);
    	*/
    	LoginUser loginObj=new  ClassPathXmlApplicationContext("databaseAccess.xml").getBean(LoginUser.class);
    	loginObj.validateUser("sachin","password");
    }
}
