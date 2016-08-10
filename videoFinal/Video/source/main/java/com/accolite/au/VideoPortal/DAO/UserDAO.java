package com.accolite.au.VideoPortal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.au.VideoPortal.Templates.UserInterface;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;

@Repository
public class UserDAO implements UserInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int AddNewUser(User user) {

		String firstName = user.getFirstname();
		String lastName = user.getLastname();
		String email = user.getEmail_id();

		String query = "insert into UserTable(firstname,lastname,email_id) values " + "('" + firstName + "','"
				+ lastName + "','" + email + "')";

		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException e) {
			
			return -1;
		}

	}
	
	 public List<Group> listGroups(User user) {
		  List<Group> groups=new ArrayList<>();
		  String query = "select * from GroupTable as groupTable inner join GroupUserTable as groupUserTable on groupTable.group_id=groupUserTable.group_id where groupUserTable.user_id="+user.getUser_id();
		  return jdbcTemplate.query(query, new ResultSetExtractor<List<Group>>() {

		   public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {

		    while (rs.next()) {
		     Group group = new Group();
		     group.setGroup_id(rs.getInt("group_id"));
		     group.setName(rs.getString("groupname"));
		     groups.add(group);
		    }
		    return groups;

		   }
		  });
		 }

	@Override
	public int DeleteUser(User user) {
		int userId = user.getUser_id();

		String query = "delete from UserTable where user_id = " + userId;

		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException e) {
			return -1;
		}

	}

	@Override
	public User RetrieveUser(int id) {

		return jdbcTemplate.query("select * from UserTable where user_id=" + id, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					User user = new User();
					user.setUser_id(Integer.parseInt(rs.getString(1)));
					user.setFirstname(rs.getString(2));
					user.setLastname(rs.getString(3));
					user.setEmail_id(rs.getString(4));
					return user;
				}

				return null;
			}
		});

	}

	@Override
	public User RetrieveUser(String email) {

		return jdbcTemplate.query("select * from UserTable where email_id like '" + email + "'",
				new ResultSetExtractor<User>() {

					@Override
					public User extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user = new User();
							user.setUser_id(Integer.parseInt(rs.getString(1)));
							user.setFirstname(rs.getString(2));
							user.setLastname(rs.getString(3));
							user.setEmail_id(rs.getString(4));
							return user;
						}

						return null;
					}
				});

	}

	public int getGroupId(int admin_id) {

		return jdbcTemplate.query("select group_id from GroupUserTable where user_id=" + admin_id,
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							Group group = new Group();
							group.setGroup_id(rs.getInt(1));
							return group.getGroup_id();// for success
						}

						return 0;// for failure.
					}
				});

	}

	public List<User> listAllUsersExceptSiteAdmin() {
		 List<User> users=new ArrayList<>();
		  String query = "Use VideoPortal select * from UserTable where user_id not in (Select * from SiteAdminTable)";
		  return jdbcTemplate.query(query, new ResultSetExtractor<List<User>>() {

		   public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
			   	
		    while (rs.next()) {
		    	User user=new User();
		     user.setEmail_id(rs.getString("email_id"));
		     user.setFirstname(rs.getString("firstname"));
		     user.setLastname(rs.getString("lastname"));
		     user.setUser_id(rs.getInt("user_id"));
		     System.out.println("dsfvb+ "+ user.getEmail_id());
		     users.add(user);
		    }
		    return users;

		   }
		  });
		 }

}
