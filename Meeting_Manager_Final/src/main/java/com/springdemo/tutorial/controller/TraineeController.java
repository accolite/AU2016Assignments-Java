package com.springdemo.tutorial.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Poll;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;
import com.springdemo.tutorial.service.MeetingManagerService;

// TODO: Auto-generated Javadoc
/**
 * The Class TraineeController.
 */
@Controller
public class TraineeController {

	/** The serv. */
	@Autowired
	private MeetingManagerService serv;

	/**
	 * Checkuser.
	 *
	 * @param request the request
	 * @return the int
	 */
	public int checkuser(HttpServletRequest request) {
		String string = (String) request.getSession().getAttribute("role");
		if (string.equals("admin"))
			return 1;
		else if (string.equals("user")) {
			return 2;
		} else {
			return -1;
		}
	}

	/**
	 * Adds the trainee.
	 *
	 * @param SessionID the session ID
	 * @param UserID the user ID
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/addTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String addTrainee(@RequestParam("SessionID") int SessionID, @RequestParam("UserID") int UserID,
			HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.addTrainee(SessionID, UserID);
	}

	/**
	 * Gets the waiting sessions.
	 *
	 * @param TraineeID the trainee ID
	 * @param request the request
	 * @return the waiting sessions
	 */
	@RequestMapping(value = "/getWaitingSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getWaitingSessions(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getWaitingSessions(TraineeID);
	}

	/**
	 * Gets the sessions.
	 *
	 * @param TraineeID the trainee ID
	 * @param request the request
	 * @return the sessions
	 */
	@RequestMapping(value = "/getJoinedSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getJoinedSessions(TraineeID);
	}

	/**
	 * Give poll.
	 *
	 * @param PollID the poll ID
	 * @param UserID the user ID
	 * @param choice the choice
	 * @param request the request
	 * @return the int
	 */
	@RequestMapping(value = "/givePoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int givePoll(@RequestParam("PollID") int PollID, @RequestParam("UserID") int UserID,
			@RequestParam("choice") int choice, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return -1;
		return serv.givePoll(PollID, UserID, choice);
	}

	/**
	 * Checkaval.
	 *
	 * @param id the id
	 * @return the session
	 */
	@RequestMapping(value = "/checkavaltrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Session checkaval(@RequestParam("id") int id) { // Take
		return serv.checkavaltrainee(id);
	}

	/**
	 * List active poll trainee.
	 *
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/listActivePollTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Poll> listActivePollTrainee(HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		int trainee = (Integer) request.getSession().getAttribute("SessionID");
		System.out.println(trainee + "ATTEMPT1");
		return serv.listActivePollTrainee(trainee);
	}
	
	
	/**
	 * Fetch feedback sessions trainee.
	 *
	 * @param TraineeID the trainee ID
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/fetchFeedbackSessionsTrainee", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> fetchFeedbackSessionsTrainee(@RequestParam("TraineeID") int TraineeID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.fetchFeedbackSessionsTrainee(TraineeID);
	}
	
	/**
	 * List files.
	 *
	 * @param sessionID the session ID
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/listFiles", method = RequestMethod.GET, produces = "application/json")
	  @ResponseBody
	  public ArrayList<String> listFiles(@RequestParam("SessionID") int sessionID, HttpServletRequest request) { // Take
	                     // int
	   if( checkuser(request) <= 0)
	    return null;                  // SessionID
	   return serv.listFiles(sessionID);
	  }

	 
	 /**
 	 * Download.
 	 *
 	 * @param fileName the file name
 	 * @param request the request
 	 * @param response the response
 	 * @return the int
 	 * @throws IOException Signals that an I/O exception has occurred.
 	 */
 	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	 public int download(@RequestParam("FileName") String fileName, HttpServletRequest request,HttpServletResponse response) throws IOException {
	  if (checkuser(request) <= 0)
	   return 0;
	  String filePath = "D:/uploads/"+fileName;
	        File downloadFile = new File(filePath);
	        FileInputStream inStream = new FileInputStream(downloadFile);
	         
	        // if you want to use a relative path to context root:
	        String relativePath = request.getServletContext().getRealPath("");
	        System.out.println("relativePath = " + relativePath);
	         
	        // obtains ServletContext
	        ServletContext context = request.getServletContext();
	         
	        // gets MIME type of the file
	        String mimeType = context.getMimeType(filePath);
	        if (mimeType == null) {        
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	         
	        // modifies response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	         
	        // forces download
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	         
	        // obtains response's output stream
	        OutputStream outStream = response.getOutputStream();
	         
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	         
	        inStream.close();
	        outStream.close(); 
	  return 1;
	 }

}
