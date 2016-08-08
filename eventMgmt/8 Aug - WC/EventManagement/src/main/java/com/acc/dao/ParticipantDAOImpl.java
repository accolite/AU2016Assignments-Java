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

import com.acc.model.Group;
import com.acc.model.Participant;
import com.acc.model.ParticipantDetails;
import com.acc.model.User;

@Repository
public class ParticipantDAOImpl implements ParticipantDAO {
	@Autowired
	JdbcTemplate jdbc;
    
	public Integer insertParticipant(ParticipantDetails participantDetails){
		
		/*
		 * Get Participant
		 */
		Participant participant=participantDetails.getParticipant();
		
		/*
		 * Get Group details of participant
		 */
		Group group = participantDetails.getGroup();
		
		
		/*
		 * See if group is present in table, else insert new one
		 */
		
		Integer group_id=null;
		String query1="";
		
		query1 = "SELECT group_id from groups where group_name='"+group.getGroup_name()+"' and event_id="+participant.getEvent_id()+";";
		group_id = jdbc.query(query1, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    Integer intVar = null;
				while(rs.next()){
			        intVar=rs.getInt("group_id");	
			    }
				return intVar;
			}
		});
		
		if(group_id==null){
			String query2="";
			query2 = "insert into groups(group_name, event_id) values('"+group.getGroup_name()+"',"+participant.getEvent_id()+")"+";";
			jdbc.update(query2);
			
			group_id = jdbc.query(query1, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
				    Integer intVar = null;
					while(rs.next()){
				        intVar=rs.getInt("group_id");	
				    }
					return intVar;
				}
			});
		}
		
		/*
		 * Get user id from table, else create one on demand
		 */
		
		String query3 = "SELECT _id from users where email_id='"+participantDetails.getUser().getEmail()+"';";
		Integer user_id = jdbc.query(query3, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    Integer intVar = null;
				while(rs.next()){
			        intVar=rs.getInt("_id");	
			    }
				return intVar;
			}
		});
		
		if(user_id==null){
			String query4 = "insert into users(email_id) values('"+participantDetails.getUser().getEmail()+"');";
			jdbc.update(query4);
			
			user_id = jdbc.query(query3, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
				    Integer intVar = null;
					while(rs.next()){
				        intVar=rs.getInt("_id");	
				    }
					return intVar;
				}
			});
		}
		
		/*
		 * Success return var
		 */
		Integer returnInt = 1;
		int role_id=0;
		
		/*
		 * Insert statements
		 */
		String query5 = "insert into participants(user_id,group_id,event_id) values('"+user_id+"','"+group_id+"','"+participant.getEvent_id()+"');";		
		String query6 = "insert into roles_users(user_id,event_id,role_id) values('"+user_id+"','"+participant.getEvent_id()+"','"+role_id+"');";		
		
		/*
		 * Execute query and store status in return var
		 */
		returnInt*=jdbc.update(query5);
		returnInt*=jdbc.update(query6);
		
		return returnInt;
	}
	
	public int insertOrganizer(String event_id, String emailId){
		
		/*
		 * Get user id from table, else create one on demand
		 */
		
		String query = "SELECT _id from users where email_id='"+emailId+"';";
		Integer user_id = jdbc.query(query, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    Integer intVar = null;
				while(rs.next()){
			        intVar=rs.getInt("_id");	
			    }
				return intVar;
			}
		});
		
		if(user_id==null){
			//can not insert null into users;
			String query1 = "insert into users(email_id) values('"+emailId+"');";
			jdbc.update(query1);
			
			user_id = jdbc.query(query, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
				    Integer intVar = null;
					while(rs.next()){
				        intVar=rs.getInt("_id");	
				    }
					return intVar;
				}
			});
		}
		/*
		 * Insert statement
		 */
		
		int role_id=1;
		String query2 = "insert into roles_users(user_id,event_id,role_id) values('"+user_id+"','"+event_id+"','"+role_id+"');";		
		
		return jdbc.update(query2);
	}
	

	public Integer removeParticipant(String event_id, String emailId){
		
		Integer returnInt = 1;
		/*
		 * Get type of event
		 */
		String query1 = "select type from events where"
				+ " _id = "+event_id;
		
		String type=jdbc.query(query1, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    String str=null;   
				while(rs.next()){
			        str=rs.getString("type");
			    }
				return str;
			}
		});
				
		/*
		 * Get user Id
		 */
		
		query1 = "select _id from users where email_id='"+emailId+"';";

		
		int user_id=jdbc.query(query1, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    int id=0;   
				while(rs.next()){
			        id=rs.getInt("_id");	
		
			    }
				return id;
			}
		});

		
		/*
		 * Get group Id
		 */
		query1 = "select group_id from participants where user_id="+user_id+";";
				
		int group_id=jdbc.query(query1, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    int id=0;   
				while(rs.next()){
			        id=rs.getInt("group_id");	

			    }
				return id;
			}
		});
		
	
		int role_id=0;
		
		/*
		 * Delete from role_users and participants either way 
		 */
		String query3 ="delete from roles_users where"+" user_id = "+user_id+" and event_id = "+event_id+" and role_id = "+role_id+";";
		returnInt*=jdbc.update(query3);
		
		String query4 ="delete from participants where"+" user_id = "+user_id+" and event_id = "+event_id+";";
		returnInt*=jdbc.update(query4);
		

		/*
		 * Delete from group if individual
		 */
		
		if(type.equals("individual")){
			String query2 ="delete from groups where"+" group_id = "+group_id+";";	
		    jdbc.update(query2);
		}
		
		return returnInt;
	}
		
	public int removeOrganizer(String event_id, String emailId){
		/*
		 * Get user detail
		 */
		String query1 = "select _id from users where email_id='"+emailId+"';";
		int user_id=jdbc.query(query1, new ResultSetExtractor<Integer>() {
 
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    int id=0;   
				while(rs.next()){
			        id=rs.getInt("_id");			
			    }
				return id;
			}
		});
		/*
		 * Delete from roles
		 */
		int role_id = 1;
		String query ="delete from roles_users where"+" user_id = "+user_id+" and event_id = "+event_id+" and role_id = "+role_id+";";
		return jdbc.update(query);
	}	
	
	public List<ParticipantDetails> getAllParticipants(int eventId){
		/*
		 * Get all details from participants of a particular event
		 */
		String query = "SELECT user_id,group_id,event_id FROM participants where"
				+ " event_id = "+eventId+";";
		
		List<ParticipantDetails> participants = jdbc.query(query, new ResultSetExtractor<ArrayList<ParticipantDetails>>() {

			public ArrayList<ParticipantDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<ParticipantDetails> list= new ArrayList<ParticipantDetails>();
				int count = 0;
				while (rs.next()){
					Participant participant = new Participant();
				    participant.setUser_id(rs.getInt("user_id"));
				    participant.setGroup_id(rs.getInt("group_id"));
				    participant.setEvent_id(rs.getInt("event_id"));
				    list.add(new ParticipantDetails());
				    list.get(count++).setParticipant(participant);
				}
				return list;
			}
		});
		
		/*
		 * For each participant, get user details and group details
		 */
		for(int i=0;i<participants.size();i++){
			query = "select _id,name,email_id from users where _id="+participants.get(i).getParticipant().getUser_id()+";";
			participants.get(i).setUser( jdbc.query(query, new ResultSetExtractor<User>() {

				public User extractData(ResultSet rs) throws SQLException, DataAccessException {
					User user = new User();
					while(rs.next()){
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email_id"));
						user.set_id(rs.getInt("_id"));
					}
					return user;
				}
			}
			));
			query = "select group_id,group_name,points,event_id from groups where group_id="+participants.get(i).getParticipant().getGroup_id()+";";
			participants.get(i).setGroup( jdbc.query(query, new ResultSetExtractor<Group>() {

				public Group extractData(ResultSet rs) throws SQLException, DataAccessException {
					Group group = new Group();
					while(rs.next()){
						group.setEvent_id(rs.getInt("event_id"));
						group.setGroup_id(rs.getInt("group_id"));
						group.setGroup_name(rs.getString("group_name"));
						group.setPoints(rs.getInt("points"));
					}
					return group;
				}
			}
			));
		}
		
		return participants;
	}
	
	
	public int addPoints(String event_id, String group_id,String points){
		
		String query1 = "select points from groups where"
				+ " group_id = "+group_id+" and event_id = "+event_id+";";
		
		int newPoints=jdbc.query(query1, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {	
			    int points=0;   
				while(rs.next()){
			        points=rs.getInt("points");	
			        }
				return points;
			}
		});
		
		newPoints+=Integer.parseInt(points);
		
		String query2="update groups set points = "+newPoints+"where"
				+ " group_id = "+group_id+" and event_id = "+event_id+";";
		
		return jdbc.update(query2);
	}
	
	public List<Group> getGroups(int eventId){
		String query = "select * from groups where event_id="+eventId+";";
		return jdbc.query(query, new ResultSetExtractor<List<Group>>() {

			public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<Group> list= new ArrayList<Group>();
				while (rs.next()){
					Group group = new Group();
					group.setEvent_id(rs.getInt("event_id"));
					group.setGroup_id(rs.getInt("group_id"));
					group.setGroup_name(rs.getString("group_name"));
					group.setPoints(rs.getInt("points"));
					list.add(group);
				}
				return list;
			}
		});
	}
}
