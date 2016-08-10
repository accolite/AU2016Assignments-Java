package com.springdemo.tutorial.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.http.HttpRequest;
import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Poll;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;
import com.springdemo.tutorial.service.MeetingManagerService;

// TODO: Auto-generated Javadoc
/**
 * The Class TrainerController.
 */
@Controller
public class TrainerController {

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
	 * Send invite.
	 *
	 * @param sessionID the session ID
	 * @param trainerID the trainer ID
	 * @param Emails the emails
	 * @param request the request
	 * @return the int[]
	 */
	@RequestMapping(value = "/sendInvite", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int[] sendInvite(@RequestParam("SessionID") int sessionID, @RequestParam("TrainerID") int trainerID,
			@RequestParam("Emails") String Emails, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.sendInvite(Emails, sessionID, trainerID);
	}

	/**
	 * Send email.
	 *
	 * @param SessionID the session ID
	 * @param Subject the subject
	 * @param Message the message
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<User> SendEmail(@RequestParam("SessionID") int SessionID, @RequestParam("Subject") String Subject,
			@RequestParam("Message") String Message, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.SendEmail(SessionID, Subject, Message);

	}

	/**
	 * Gets the sessions.
	 *
	 * @param TrainerID the trainer ID
	 * @param request the request
	 * @return the sessions
	 */
	@RequestMapping(value = "/getSessions", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Session> getSessions(@RequestParam("TrainerID") int TrainerID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.getSessions(TrainerID);
	}

	/**
	 * Checkaval.
	 *
	 * @param id the id
	 * @return the session
	 */
	@RequestMapping(value = "/checkavaltrainer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Session checkaval(@RequestParam("id") int id) { // Take
		return serv.checkaval(id);
	}

	/**
	 * Close poll.
	 *
	 * @param PollID the poll ID
	 * @param request the request
	 * @return the int
	 */
	@RequestMapping(value = "/closePoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int closePoll(@RequestParam("PollID") int PollID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return 0;
		return serv.closePoll(PollID);
	}

	/**
	 * List active poll trainer.
	 *
	 * @param request the request
	 * @return the array list
	 */
	@RequestMapping(value = "/listActivePollTrainer", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ArrayList<Poll> listActivePollTrainer(HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		int trainer = (Integer) request.getSession().getAttribute("SessionID");
		System.out.println(trainer + "ATTEMPT1");
		return serv.listActivePollTrainer(trainer);
	}

	/**
	 * Adds the poll.
	 *
	 * @param q the q
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @param o3 the o 3
	 * @param o4 the o 4
	 * @param sessionID the session ID
	 * @param request the request
	 * @return the int
	 */
	@RequestMapping(value = "/addPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int addPoll(@RequestParam("q") String q, @RequestParam("o1") String o1, @RequestParam("o2") String o2,
			@RequestParam("o3") String o3, @RequestParam("o4") String o4, @RequestParam("SessionID") int sessionID,
			HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return 0;
		return serv.addPoll(q, o1, o2, o3, o4, sessionID);
	}

	/**
	 * Fetch poll.
	 *
	 * @param PollID the poll ID
	 * @param request the request
	 * @return the string[]
	 */
	@RequestMapping(value = "/fetchPoll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String[] fetchPoll(@RequestParam("PollID") int PollID, HttpServletRequest request) {
		if (checkuser(request) <= 0)
			return null;
		return serv.fetchPoll(PollID);
	}

	/**
	 * Upload files.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the int
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int uploadFiles(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // Take
		if (checkuser(request) <= 0)
			return 0;

		final String UPLOAD_DIRECTORY = "D:/uploads";
		String string = null;
		String string2 = null;
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						System.out.println(name);
						string = name;
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
					} else if (item.isFormField()) {
						if (item.getFieldName().equals("SessionID")) {
							string2 = item.getString();
						}
					}
				}
				int a = Integer.parseInt(string2);
				serv.uploadFiles(a, string);

				// File uploaded successfully
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				request.setAttribute("message", "File Upload Failed due to " + ex);
			}

		} else {
			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		response.sendRedirect("/SpringAU2016Demo/indextest.html#/hometest");
		//request.getRequestDispatcher("/indextest.html#/hometest").forward(request, response);
		return 1;
	}
}
