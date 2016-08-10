package com.acc.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.dao.ParticipantDAO;
import com.acc.model.Group;
import com.acc.model.ParticipantDetails;

@Service
public class ParticipantServicesImpl implements ParticipantServices {
	@Autowired
	ParticipantDAO participantDAO;
	
	public ParticipantDAO getParticipantDAO() {
		return participantDAO;
	}

	public void setParticipantDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}

	public Integer registerParticipant(List<ParticipantDetails> participantDetails){
		Integer returner = 1;
		for(ParticipantDetails participantDetail : participantDetails){
			Integer present = participantDAO.insertParticipant(participantDetail);
			if(present!=0) addmail(participantDetail);	
			returner*=present;
		}
		return returner;
	}
	
	public Integer insertOrganizer(String event_id,String emailId){
		return participantDAO.insertOrganizer(event_id, emailId);
	}
	
	public Integer deregisterParticipant(String event_id, String emailId){
		return participantDAO.removeParticipant(event_id, emailId);
		
	}

	public Integer removeOrganizer(String event_id, String emailId){
		return participantDAO.removeOrganizer(event_id, emailId);
	}
	
	public List<ParticipantDetails> getAllParticipants(int eventId){
		return participantDAO.getAllParticipants(eventId);
	}
	
	public List<Group> getAllGroups(Integer eventId){
		return participantDAO.getGroups(eventId);
	}
	
	public Integer addPoints(String event_id, String group_id,String points){
		return participantDAO.addPoints(event_id, group_id, points);
	}

	public boolean isOrganizer(String email, Integer event_id) {
		if(participantDAO.isOrganizer(email, event_id))
			return true;
		return false;
	}
	
	 private void addmail(ParticipantDetails participantDetails){
	     try{
	      @SuppressWarnings("unused")
		InitialContext initCtx = new InitialContext();
	      
	      	 final String username = "ravi.kalmodia@accoliteindia.com";
	         final String password = "ravik5253";
	         
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

	         msg.setRecipients(Message.RecipientType.TO,participantDetails.getUser().getEmail());
	         msg.setSubject("Accolite Events | Registered to event "+participantDetails.getParticipant().getEvent_id());
	         msg.setSentDate(new Date());
	         msg.setText("Congrats you are added to this event!!\n");

	         Transport.send(msg);
	     
	     }catch(Exception e){
	      e.printStackTrace();
	     }
	    }
}
