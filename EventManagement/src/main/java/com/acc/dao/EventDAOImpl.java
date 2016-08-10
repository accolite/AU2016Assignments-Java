/****************************************************************************
 * Copyright (c) 2016 by Accolite.com. All rights reserved
 *
 * Created date :: Aug 10, 2016
 *
 *  @author :: Ravi Kalmodia, Sharukh Mohamed
 * ***************************************************************************
 */
package com.acc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.acc.model.Event;
import com.acc.model.EventDetails;
import com.acc.model.ParticipantDetails;
import com.acc.model.User;

/**
 * The Class EventDAOImpl.
 */
@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private JdbcTemplate jdbc;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public ParticipantDAO getParticipantDAO() {
		return participantDAO;
	}

	public void setParticipantDAO(ParticipantDAO participantDAO) {
		this.participantDAO = participantDAO;
	}

	@Autowired
	ParticipantDAO participantDAO;

	/* (non-Javadoc)
	 * @see com.acc.dao.EventDAO#getEvent(java.lang.Integer)
	 */
	public EventDetails getEvent(Integer event_id){
		/*
		 * Getting event by id
		 */
		String query = "select * from events where _id="+event_id+";";
		EventDetails event = jdbc.query(query, new ResultSetExtractor<EventDetails>() {

			public EventDetails extractData(ResultSet rs) throws SQLException, DataAccessException {
				EventDetails eventDetails= new EventDetails();

				Event event = new Event();
				while (rs.next()){
					event.set_id(rs.getInt("_id"));
					event.setName(rs.getString("event_name"));
					event.setDescription(rs.getString("description"));
					event.setStart_time(rs.getTimestamp("start_time"));
					event.setEnd_time(rs.getTimestamp("end_time"));
					event.setType(rs.getString("type"));
					event.setVenue(rs.getString("venue"));
				}
				eventDetails.setEvent(event);
				return eventDetails;
			}
		});
		/*
		 * Getting all organizers of event_id
		 */
		query = "select _id,name,email_id from users where _id in "
				+"(select user_id from roles_users where role_id=1 and event_id="+event.getEvent().get_id()+")";
		event.setOrganizers( jdbc.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> users = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email_id"));
					user.set_id(rs.getInt("_id"));
					users.add(user);
				}
				return users;
			}
		}
				)
				);
		return event;
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.EventDAO#getAllEvents()
	 */
	public List<EventDetails> getAllEvents(){
		
		/*
		 * Getting all events
		 */
		String query = "select * from events";

		List<EventDetails> events = jdbc.query(query, new ResultSetExtractor<ArrayList<EventDetails>>() {

			public ArrayList<EventDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<EventDetails> list= new ArrayList<EventDetails>();
				int count = 0;
				while (rs.next()){
					Event event = new Event();
					event.set_id(rs.getInt("_id"));
					event.setName(rs.getString("event_name"));
					event.setDescription(rs.getString("description"));
					event.setStart_time(rs.getTimestamp("start_time"));
					event.setEnd_time(rs.getTimestamp("end_time"));
					event.setType(rs.getString("type"));
					event.setVenue(rs.getString("venue"));
					list.add(new EventDetails());
					list.get(count).setEvent(event);
					count+=1;
				}
				return list;
			}
		});
		/*
		 * Getting all organizers of all events
		 */
		for(EventDetails event: events){
			query = "select _id,name,email_id from users where _id in "
					+"(select user_id from roles_users where role_id=1 and event_id="+event.getEvent().get_id()+")";
			event.setOrganizers( jdbc.query(query, new ResultSetExtractor<List<User>>() {

				public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<User> users = new ArrayList<User>();
					while(rs.next()){
						User user = new User();
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email_id"));
						user.set_id(rs.getInt("_id"));
						users.add(user);
					}
					return users;
				}
			}
					));
		}

		return events;
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.EventDAO#InsertEvent(com.acc.model.EventDetails)
	 */
	public EventDetails InsertEvent(EventDetails eventDetails){
		Event event = eventDetails.getEvent();
		/*
		 * Insert the event
		 */
		String query = "insert into events(event_name, description, type, start_time, end_time, venue) values('"
				+event.getName()+"','"+event.getDescription()+"','"+event.getType()+"','"+event.getStart_time()
				+"','"+event.getEnd_time()+"','"+event.getVenue()+"');";

		Integer organizerInsert = jdbc.update(query);

		/*
		 * Get inserted id
		 */
		String query1 = "select _id from events where event_name='"+event.getName()+"' and description='"
				+event.getDescription()+"';";
		event.set_id(jdbc.query(query1,new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				Integer integer = null;
				while(rs.next()){
					integer = rs.getInt("_id");
				}
				return integer;
			}
		}
				));
		/*
		 * Insert list of organizers
		 */

		List<User> organizers = eventDetails.getOrganizers();

		for(User organizer: organizers){
			organizerInsert*=participantDAO.insertOrganizer(new Integer(event.get_id()).toString(), organizer.getEmail());
		}
		if(organizerInsert>0)
			return eventDetails;
		return null;
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.EventDAO#deleteEvent(int)
	 */
	public int deleteEvent(int eventId){
		String query = "delete from events where _id="+eventId+";";
		return jdbc.update(query);
	}

	/* (non-Javadoc)
	 * @see com.acc.dao.EventDAO#updateEvent(com.acc.model.EventDetails)
	 */
	public Integer updateEvent(EventDetails eventDetails) {
		Event event = eventDetails.getEvent();

		String query= "update events set event_name = '"+event.getName()+"',description = '"+event.getDescription()+"',type = '"+event.getType()+"',start_time = '"+event.getStart_time()+"',end_time = '"+event.getEnd_time()+"',venue = '"+event.getVenue()+"' where _id="+event.get_id()+";";

		jdbc.update(query);
		
		/*
		 * Get updated organizers
		 */
		List<User> updated_organizers= eventDetails.getOrganizers();

		query = "select _id,name,email_id from users where _id in "
				+"(select user_id from roles_users where role_id=1 and event_id="+event.get_id()+")";

		/*
		 * See if previous organizers
		 */
		List<User> previous_organizers	=  jdbc.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> users = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email_id"));
					user.set_id(rs.getInt("_id"));
					users.add(user);
				}
				return users;
			}
		});

		/*
		 * inserting new organizer
		 */

		Integer organizerUpdate = 1;

		for(User newuser: updated_organizers){
			boolean flag=false;
			for(User olduser: previous_organizers){				
				if((newuser.getEmail()).equals(olduser.getEmail())){
					flag=true;
					break;
				} 	                       
			}
			if(flag==false)
				organizerUpdate*=participantDAO.insertOrganizer(new Integer(event.get_id()).toString(),newuser.getEmail());		

		}

		/* 
		 * deleting old organizer	
		 */

		for(User olduser: previous_organizers){	
			boolean flag=false;
			for(User newuser: updated_organizers){	
				if((newuser.getEmail()).equals(olduser.getEmail())){
					flag=true;
					break;
				} 	                       
			}
			if(flag==false)
				organizerUpdate*=participantDAO.removeOrganizer(new Integer(event.get_id()).toString(),olduser.getEmail());		
		}		

		/*
		 * Setting updated events organizers
		 */
		
		query = "select _id,name,email_id from users where _id in "
				+"(select user_id from roles_users where role_id=1 and event_id="+eventDetails.getEvent().get_id()+")";
		eventDetails.setOrganizers( jdbc.query(query, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> users = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email_id"));
					user.set_id(rs.getInt("_id"));
					users.add(user);
				}
				return users;
			}
		}
				));

		/*
		 * Mail all participants for update
		 */
		List<ParticipantDetails> participants = participantDAO.getAllParticipants(event.get_id());
		com.acc.util.Mailer.mailAllOnUpdate(participants, eventDetails);
		System.out.println(updated_organizers+"  "+previous_organizers);

		/*
		 * Return update status
		 */
		return organizerUpdate;


	}

}
