package com.accolite.au.VideoPortal.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.au.VideoPortal.DAO.ApprovalDAO;
import com.accolite.au.VideoPortal.DAO.GroupAdminDAO;
import com.accolite.au.VideoPortal.DAO.SiteAdminDAO;
import com.accolite.au.VideoPortal.DAO.UserDAO;
import com.accolite.au.VideoPortal.DAO.VideoDAO;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;
@Service
public class ApprovalService {
 @Autowired
 private UserDAO user_dao;
 @Autowired
 private SiteAdminDAO site_DAO;
 @Autowired
 private GroupAdminDAO group_DAO;
 @Autowired
 private VideoDAO video_DAO;
 @Autowired
 private ApprovalDAO app_DAO;
 public List<Video> fetchVideoForRoles(String email) {
  User user=user_dao.RetrieveUser(email);
  if(site_DAO.isGroupAdmin(user)!=null)
  {
	  System.out.println("fetching all videos for group admin");
   List<Video> videos=new ArrayList<Video>();
   videos=app_DAO.fetchGroupRelatedVideoForGroupAdmin(user);
   return videos;
  }
  else if(site_DAO.isSiteAdmin(user)!=null)
  {
	  System.out.println("fetching all videos for site admin");
   List<Video> videos=new ArrayList<Video>();
   videos=app_DAO.fetchAllVideo(user);
   return videos;
  }
  else
  {

	  System.out.println("fetching all videos for users");
   List<Video> videos=new ArrayList<Video>();
   videos=app_DAO.fetchGroupRelatedVideoForUser(user);
   return videos;
  }
 }
 public void sendApprovalEmail(String email) throws NamingException
 {   
    
  final String username = "shremavideoportal@gmail.com";
  final String password = "video12345";

  Properties props = new Properties();
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.port", "587");

  Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
    });

  try {

   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("shremavideoportal@gmail.com"));
   message.setRecipients(Message.RecipientType.TO,
    InternetAddress.parse(email));
   message.setSubject("Video Approved ");
   message.setText("Your video has been approved,"
    + "\n\n!");

   Transport.send(message);

   System.out.println("Done");

  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
 
     }
 
 public void sendRejectionEmail(String email) throws NamingException
 {
 final String username = "shremavideoportal@gmail.com";
 final String password = "video12345";

 Properties props = new Properties();
 props.put("mail.smtp.auth", "true");
 props.put("mail.smtp.starttls.enable", "true");
 props.put("mail.smtp.host", "smtp.gmail.com");
 props.put("mail.smtp.port", "587");

 Session session = Session.getInstance(props,
   new javax.mail.Authenticator() {
  protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(username, password);
  }
   });

 try {

  Message message = new MimeMessage(session);
  message.setFrom(new InternetAddress("shremavideoportal@gmail.com"));
  message.setRecipients(Message.RecipientType.TO,
   InternetAddress.parse(email));
  message.setSubject("Video Rejected");
  message.setText("Your video has been rejected,"
   + "\n\n!");

  Transport.send(message);

  System.out.println("Done");

 } catch (MessagingException e) {
  throw new RuntimeException(e);
 }  
 }
 public void approveThisVideo(int video_id, String email) throws NamingException {
  User user=user_dao.RetrieveUser(email);
  Video video=video_DAO.RetrieveVideo(video_id);
  int result=group_DAO.ApproveVideo(video, user);
  System.out.println("result="+result);
  User user1=video_DAO.RetrieveEmailOfUserWhoAddedVideo(video);
 // String email1="shremanishu@gmail.com";
  System.out.println("user1 email= "+user1.getEmail_id());
  sendApprovalEmail(user1.getEmail_id());
 // sendApprovalEmail(email1);
 }
  
 public void rejectThisVideo(int video_id, String email) throws NamingException {
  User user=user_dao.RetrieveUser(email);
  Video video=video_DAO.RetrieveVideo(video_id);
  System.out.println("herer"+video.getVideo_id());
  
  User user1=video_DAO.RetrieveEmailOfUserWhoAddedVideo(video);
  group_DAO.RejectVideo(video, user);
  System.out.println("user1 reject email= "+user1.getEmail_id());
  sendRejectionEmail(user1.getEmail_id());
 }

 
}