package com.springdemo.tutorial.testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.springdemo.tutorial.jdbctemplate.JDBCTemplateDao;
import com.springdemo.tutorial.model.Feedback;
import com.springdemo.tutorial.model.Poll;
import com.springdemo.tutorial.model.Session;
import com.springdemo.tutorial.model.User;
import com.springdemo.tutorial.service.MeetingManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MeetingManagerSericeTest {
	@Autowired
	private JDBCTemplateDao jdbc;
	private MeetingManagerService meetingManagerService;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	public MeetingManagerSericeTest() {
	
	}

	@Before
	public void setUp(){
		meetingManagerService =new MeetingManagerService();
		ReflectionTestUtils.setField(meetingManagerService, "jdbc", jdbc);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));

	}
	
	@After
	public void tearDown() throws Exception {
		 System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testfetchFeedback(){
		int session_id=2;
		Feedback result= meetingManagerService.fetchFeedback(session_id);
		int result_id=result.getSessionID();
		assertEquals(result_id,-1);	
	}
	
	@Test
	public void testavgFeedback(){
		int sessionID=70;
		int f1=3,f2=3,f3=3,f4=3;
		Feedback result= meetingManagerService.avgFeedback(sessionID,f1,f2,f3,f4,1);
		int result_id=result.getSessionID();
		int rf1=(int) result.getFeedback1();
		int rf2=(int) result.getFeedback2();
		int rf3=(int) result.getFeedback3();
		int rf4=(int) result.getFeedback4();
		assertEquals(result_id,sessionID);	
		assertEquals(rf1,f1);	
		assertEquals(rf2,f2);	
		assertEquals(rf3,f3);	
		assertEquals(rf4,f4);	
	}

	
	@Test
	public void testaddTrainee(){
		int sessionID=3;
		int userID=2;
		String r=meetingManagerService.addTrainee(sessionID, userID);
		assertEquals(r,"Trainee added");
	}
	
	@Test
	public void testgetWaitingSessions(){
		int traineeID=4;
		ArrayList<Session> r= meetingManagerService.getWaitingSessions(traineeID);
		int[] sessionID = new int[r.size()];
		for(int i=0; i<r.size(); i++)
			sessionID[i] = r.get(i).getSessionID();
		int[] expectedSessionIDS = new int[]{1,10};
		assertArrayEquals(expectedSessionIDS, sessionID);
	}
	
	@Test
	public void testgetJoinedSessions(){
		int traineeID=1;
		ArrayList<Session> r= meetingManagerService.getJoinedSessions(traineeID);
		int[] sessionID = new int[r.size()];
		for(int i=0; i<r.size(); i++)
			sessionID[i] = r.get(i).getSessionID();
		int[] expectedSessionIDS = new int[]{1,2,6};
		assertArrayEquals(expectedSessionIDS, sessionID);

		}
	
	@Test
	public void testgetSessions(){
		int trainerID=3;
		ArrayList<Session> r= meetingManagerService.getSessions(trainerID);
		int[] sessionID = new int[r.size()];
		for(int i=0; i<r.size(); i++)
			sessionID[i] = r.get(i).getSessionID();
		int[] expectedSessionIDS = new int[]{2,6};
		assertArrayEquals(expectedSessionIDS, sessionID);
	}
	
	
	@Test
	public void testlistActivePollTrainer(){
		int trainerID=3;
		ArrayList<Poll> r= meetingManagerService.listActivePollTrainer(trainerID);
		int[] pollID = new int[r.size()];
		for(int i=0; i<r.size(); i++)
			pollID[i]=r.get(i).getPollID();
		int[] expectedpollID= new int[]{2};
		assertArrayEquals(expectedpollID, pollID);
	}
	
}
