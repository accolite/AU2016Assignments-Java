package com.acc.testDAO;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acc.dao.EventDAO;
import com.acc.model.Event;
import com.acc.model.EventDetails;
import com.acc.model.User;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:application-config.xml"})
public class TestEventDAO {
	@Autowired
	EventDAO eventDAO;

	@Test
	public void insertEventTest()
	{
		Timestamp timestamp= new Timestamp(new Date().getTime());
		Event event= new Event(10,"Test Event","Testing add event of services","individual", timestamp,timestamp,"Seminar hall");
		List<User> organizers= new ArrayList();
		EventDetails eventDetails=  new EventDetails(event,organizers) ;
		EventDetails testEventDetails = eventDAO.InsertEvent(eventDetails);
		assertEquals(testEventDetails,eventDetails);
	}

}
