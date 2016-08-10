/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
*
* Created date :: Aug 10, 2016
*
*  @author :: Ravi Kalmodia, Sharukh Mohamed
* ***************************************************************************
*/
package com.acc.util;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import com.acc.model.EventDetails;
import com.acc.model.ParticipantDetails;
import com.acc.model.Person;
public class Mailer {

 	final static String username = "ravi.kalmodia@accoliteindia.com";
    final static String password = "ravik5253";
 
	/**
	 * Mail all on register.
	 *
	 * @param participants the participants
	 * @param event the event
	 */
	public static void mailAllOnRegister(List<ParticipantDetails> participants, EventDetails event){
		    if(participants!=null && participants.size()>0) {
			try{
		      @SuppressWarnings("unused")
		      InitialContext initCtx = new InitialContext();
		         
		         Properties props = new Properties();
		         props.put("mail.smtp.host", "smtp.gmail.com");
		         props.put("mail.from", username);
		         props.put("mail.smtp.starttls.enable", "true");
		         props.put("mail.smtp.port", "587");
		         props.put("mail.smtp.auth", "true"); 
		         props.put	("mail.debug", "true");
		         Authenticator auth = new Authenticator() {
		                //override the getPasswordAuthentication method
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            };
		         javax.mail.Session session = javax.mail.Session.getInstance(props, auth);
		         MimeMessage msg = new MimeMessage(session);
		         InternetAddress emails[] = new InternetAddress[participants.size()];
		         
		         for(int i=0;i<participants.size();i++)
		        	 emails[i] = new InternetAddress(participants.get(i).getUser().getEmail());
		         
		         msg.setRecipients(Message.RecipientType.TO, emails);
		         msg.setSubject("Accolite Events | Registered to event "+ event.getEvent().getName());
		         msg.setSentDate(new Date());
		         String createMsg = "Congrats you are added to this event !!\n";
		         createMsg+= "Event Details:\n"; 
		         createMsg+= "Event name: "+event.getEvent().getName()+"\n\n";
		         createMsg+= "Description: "+event.getEvent().getDescription()+"\n\n";
		         createMsg+= "Venue: "+event.getEvent().getVenue()+"\n";
		         createMsg+= "Start time: "+event.getEvent().getStart_time()+"\n";
		         createMsg+= "End time: "+event.getEvent().getEnd_time()+"\n";
		         createMsg+= "organizers: \n";
		         for(Person organizer: event.getOrganizers()){
		        	 createMsg+=organizer.getName()==null?
		        			 organizer.getEmail().substring(0, organizer.getEmail().indexOf('.')):organizer.getName();
		        	 createMsg+=(", "+organizer.getEmail());
		         }
		         msg.setText(createMsg);
		         

		         Transport.send(msg);
		     
		     }catch(Exception e){
		      e.printStackTrace();
		     }
		}
	}
	
	/**
	 * Mail all on update.
	 *
	 * @param participants the participants
	 * @param event the event
	 */
	public static void mailAllOnUpdate(List<ParticipantDetails> participants, EventDetails event){
		if(participants!=null && participants.size()>0){
		try{
		      @SuppressWarnings("unused")
		      InitialContext initCtx = new InitialContext();
		         
		         Properties props = new Properties();
		         props.put("mail.smtp.host", "smtp.gmail.com");
		         props.put("mail.from", username);
		         props.put("mail.smtp.starttls.enable", "true");
		         props.put("mail.smtp.port", "587");
		         props.put("mail.smtp.auth", "true"); 
		         props.put	("mail.debug", "true");
		         Authenticator auth = new Authenticator() {
		                //override the getPasswordAuthentication method
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(username, password);
		                }
		            };
		         javax.mail.Session session = javax.mail.Session.getInstance(props, auth);
		         MimeMessage msg = new MimeMessage(session);
		         InternetAddress emails[] = new InternetAddress[participants.size()];
		         
		         for(int i=0;i<participants.size();i++)
		        	 emails[i] = new InternetAddress(participants.get(i).getUser().getEmail());
		         
		         msg.setRecipients(Message.RecipientType.TO, emails);
		         msg.setSubject("Accolite Events | Updated event "+ event.getEvent().getName());
		         msg.setSentDate(new Date());
		         String createMsg = "The following are the updated Event details !!\n";
		         createMsg+= "Event Details:\n"; 
		         createMsg+= "Event name: "+event.getEvent().getName()+"\n\n";
		         createMsg+= "Description: "+event.getEvent().getDescription()+"\n\n";
		         createMsg+= "Venue: "+event.getEvent().getVenue()+"\n";
		         createMsg+= "Start time: "+event.getEvent().getStart_time()+"\n";
		         createMsg+= "End time: "+event.getEvent().getEnd_time()+"\n";
		         createMsg+= "organizers: \n";
		         for(Person organizer: event.getOrganizers()){
		        	 createMsg+=organizer.getName()==null?
		        			 organizer.getEmail().substring(0, organizer.getEmail().indexOf('.')):organizer.getName();
		        	 createMsg+=(", "+organizer.getEmail());
		         }
		         msg.setText(createMsg);
		         

		         Transport.send(msg);
		     
		     }catch(Exception e){
		      e.printStackTrace();
		     }
		}
	}
}
