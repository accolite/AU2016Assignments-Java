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
import com.acc.model.User;

@Repository
public class EventDAOImpl implements EventDAO {
	@Autowired
	private JdbcTemplate jdbc;

	@Autowired
	ParticipantDAO participantDAO;

	public List<EventDetails> getAllEvents(){
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

	public EventDetails InsertEvent(EventDetails eventDetails){
		Event event = eventDetails.getEvent();
		String query = "insert into events(event_name, description, type, start_time, end_time, venue) values('"
				+event.getName()+"','"+event.getDescription()+"','"+event.getType()+"','"+event.getStart_time()
				+"','"+event.getEnd_time()+"','"+event.getVenue()+"');";

		Integer organizerInsert = jdbc.update(query);

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

		List<User> organizers = eventDetails.getOrganizers();

		for(User organizer: organizers){
			organizerInsert*=participantDAO.insertOrganizer(new Integer(event.get_id()).toString(), organizer.getEmail());
		}
		if(organizerInsert>0)
			return eventDetails;
		return null;
	}

	public int deleteEvent(int eventId){
		String query = "delete from events where _id="+eventId+";";
		return jdbc.update(query);
	}

	public Integer updateEvent(EventDetails eventDetails) {
		Event event = eventDetails.getEvent();

		String query= "update events set event_name = "+event.getName()+",description = "+event.getDescription()+",type = "+event.getType()+"start_time = "+event.getStart_time()+",end_time = "+event.getEnd_time()+",venue = "+event.getVenue()+" where"+" user_id = "+event.get_id()+";";

		List<User> updated_organizers= eventDetails.getOrganizers();

		query = "select _id,name,email_id from users where _id in "
				+"(select user_id from roles_users where role_id=1 and event_id="+event.get_id()+")";

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

		// inserting new organizer

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

		// deleting old organizer	

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


		System.out.println(updated_organizers+"  "+previous_organizers);


		return organizerUpdate;


	}

}
