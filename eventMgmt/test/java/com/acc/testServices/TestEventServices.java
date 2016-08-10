package com.acc.testServices;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.acc.dao.EventDAO;
import com.acc.model.Event;
import com.acc.model.EventDetails;
import com.acc.model.User;
import com.acc.service.EventServices;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:application-config.xml"})
public class TestEventServices {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Autowired
	EventServices eventServices;
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testAddEvent()
	{	
		Timestamp timestamp= new Timestamp(new Date().getTime());
		Event event= new Event(10,"Test Event","Testing add event of services","individual", timestamp,timestamp,"Seminar hall");
		List<User> organizers= new ArrayList();
		EventDetails eventDetails=  new EventDetails(event,organizers) ;
		EventDetails testEventDetails = eventServices.addEvent(eventDetails);
		assertEquals(testEventDetails,eventDetails);
		
	}

	@Test
	public void viewAllEventsTest()
	{	Timestamp timestamp= new Timestamp(new Date().getTime());
		Event event= new Event(10,"Test Event","Testing add event of services","individual", timestamp,timestamp,"Seminar hall");
		List<User> organizers= new ArrayList();
		EventDetails eventDetails=  new EventDetails(event,organizers) ;
		/*mocking event DAO*/
		EventDAO eventDAOMock= Mockito.mock(EventDAO.class);
		List<EventDetails> listEventDetails=new ArrayList();
		listEventDetails.add(eventDetails);
		 when(eventDAOMock.getAllEvents()).thenReturn(listEventDetails);
		 ReflectionTestUtils.setField(eventServices, "eventDAO", eventDAOMock);
		 List<EventDetails> testListEventDetails=eventServices.viewAllEvents();
		 assertEquals(testListEventDetails,listEventDetails);
	}
	
	@Test
	public void deleteEventTest()
	{
		int event_id=10;
		EventDAO eventDAOMock= Mockito.mock(EventDAO.class);
		 when(eventDAOMock.deleteEvent(event_id)).thenReturn(1);
		 ReflectionTestUtils.setField(eventServices, "eventDAO", eventDAOMock);
		 int testEvent_id=eventServices.deleteEvent(event_id);
		 assertEquals(testEvent_id,1);
	}

}
