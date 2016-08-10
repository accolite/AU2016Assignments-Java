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

import com.accolite.au.VideoPortal.Templates.SiteAdminInterface;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;

@Repository
public class SiteAdminDAO implements SiteAdminInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * TO add a site admin returns 1 if site admin has been added returns 0 if
	 * site admin has not been added returns -1 if an exception has occured
	 */
	
	public List<Group> listAllGroups() {
		  // TODO Auto-generated method stub
		  List<Group> groups=new ArrayList<>();
		  String query = "select * from GroupTable";
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
	
	public int AddAdmin(User user) {
		  int user_id = user.getUser_id();
		  String query = "Use VideoPortal insert into dbo.SiteAdminTable values (" + user_id + ")";
		  try {
		   if (jdbcTemplate.update(query) > 0)
		    return 1;
		   else
		    return 0;
		  } catch (DataAccessException s) {
		   return -1;
		  }

		 }
	public int DeleteAdmin(User user) {
		  int user_id = user.getUser_id();
		  String query = "Use VideoPortal Delete from SiteAdminTable where user_id= " + user_id ;
		  try {
		   if (jdbcTemplate.update(query) > 0)
		    return 1;
		   else
		    return 0;
		  } catch (DataAccessException s) {
		   return -1;
		  }
		 }

	public int CreateGroup(Group group) {
		String query = "Use VideoPortal insert into GroupTable(groupname) values('" + group.getName() + "')";
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}

	}

	@Override
	public int DeleteGroup(Group group) {

		String query = "delete from GroupTable where group_id = " + group.getGroup_id();
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}
	}
	public int getUserIdBasedOnEmail(String email) {

		return jdbcTemplate.query(
				"select user_id from dbo.UserTable where email_id like  " + "'" + email + "'",
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user1 = new User();
							user1.setUser_id(rs.getInt(1));

							return user1.getUser_id();// This is the id of admin
						}
						return 0;// For failure.
					}
				});

	}
	@Override
	public int RemoveEntriesInGroupAdmin(Group group) {

		String query = "delete from GroupAdminTable where group_id = " + group.getGroup_id();
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}
	}

	@Override
	public int RemoveEntriesInGroupUserTable(Group group) {
		String query = "delete from GroupUserTable where group_id = " + group.getGroup_id();
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}
	}

	@Override
	public int RemoveEntriesInGroupVideoTable(Group group) {

		String query = "delete from GroupVideoTable where group_id = " + group.getGroup_id();
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}
	}

	/*
	 * TO create a group admin returns 1 if group admin has been created returns
	 * 0 if group admin has not been created returns -1 if an exception has
	 * occured
	 */
	// public int CreateGroupAdmin(Group group, User groupAdmin) {
	// String query = "Use VideoPortal insert into
	// GroupAdminTable(group_id,admin_id) values('" + group.getGroup_id()
	// + "','" + groupAdmin.getUser_id() + "')";
	// try {
	// if (jdbcTemplate.update(query) > 0)
	// return 1;
	// else
	// return 0;
	// } catch (DataAccessException s) {
	// return -1;
	// }
	//
	// }
	
	public User RetrieveSiteAdminBasedOnEmail(String email) {

		  return jdbcTemplate.query("select * from dbo.UserTable where email_id like " + "'" + email + "'",
		    new ResultSetExtractor<User>() {

		     @Override
		     public User extractData(ResultSet rs) throws SQLException, DataAccessException {

		      while (rs.next()) {
		       User user = new User();
		       user.setUser_id(Integer.parseInt(rs.getString(1)));

		       return user;
		      }

		      return null;
		     }
		    });

		 }
	public int CreateGroupAdmin(Group group, User user) {
		String query = "Use VideoPortal insert into GroupAdminTable(group_id,admin_id) values('" + group.getGroup_id()
				+ "','" + user.getUser_id() + "')";
		try {
			if (jdbcTemplate.update(query) > 0)
				return 1;
			else
				return 0;
		} catch (DataAccessException s) {
			return -1;
		}

	}

	public User isSiteAdmin(User user) {
		int id = user.getUser_id();
		
		
		String query = "Select * from SiteAdmintable where user_id='" + id + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while (rs.next()) {
					User user1 = new User();
					int user_id = rs.getInt("user_id");
					user1.setUser_id(user_id);
					return user1;

				}
				return null;

			}
		});

	}

	public User isGroupAdmin(User user)
	 {
	  return jdbcTemplate.query(
	    "select admin_id from dbo.GroupAdminTable where admin_id =" + user.getUser_id(),
	    new ResultSetExtractor<User>() {

	     @Override
	     public User extractData(ResultSet rs) throws SQLException, DataAccessException {
	    	 User user=new User();
	      if(rs.next()) {
	      
	       user.setUser_id(rs.getInt("admin_id"));
	       return user;// The user is a group admin
	      }
	      return null;// The user is not a group admin
	     }
	    });
	 }
	
/*	@Override
	public User RetrieveSiteAdmin(int id) {

		return jdbcTemplate.query("select * from dbo.SiteAdminTable where user_id=" + id,
				new ResultSetExtractor<User>() {

					@Override
					public User extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user = new User();
							user.setUser_id(Integer.parseInt(rs.getString(1)));

							return user;
						}

						return null;
					}
				});

	}*/

	@Override
	 public User RetrieveSiteAdminExistsAsUser(String name) {

	  return jdbcTemplate.query("Use VideoPortal select * from dbo.UserTable where firstname like '" + name + "'",
	    new ResultSetExtractor<User>() {

	     @Override
	     public User extractData(ResultSet rs) throws SQLException, DataAccessException {

	      while (rs.next()) {
	       User user = new User();
	       user.setUser_id(Integer.parseInt(rs.getString(1)));

	       return user;
	      }

	      return null;
	     }
	    });

	 }
	
	public User RetrieveSiteAdmin(String name) {

		  return jdbcTemplate.query("select * from dbo.UserTable where firstname like " + "'" + name + "'",
		    new ResultSetExtractor<User>() {

		     @Override
		     public User extractData(ResultSet rs) throws SQLException, DataAccessException {

		      while (rs.next()) {
		       User user = new User();
		       user.setUser_id(Integer.parseInt(rs.getString(1)));

		       return user;
		      }

		      return null;
		     }
		    });

		 }
	
	// Checks whether Group Already exists
	public boolean groupAlreadyExists(String group_name) {
		return jdbcTemplate.query("select * from dbo.GroupTable where groupname=" + "'" + group_name + "'",
				new ResultSetExtractor<Boolean>() {

					@Override
					public Boolean extractData(ResultSet rs) throws SQLException, DataAccessException {

						if (rs.next()) {
							return true;// Group Already Exists
						}

						return false;
					}
				});
	}

	// Fetches the group_id from GroupTable so that admin_id + group_id can be
	// added in GroupAdmin Table.
	public int getGroupId(Group group) {

		return jdbcTemplate.query("select group_id from dbo.GroupTable where groupname=" + "'" + group.getName() + "'",
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							Group group1 = new Group();
							group1.setGroup_id(rs.getInt(1));

							return group1.getGroup_id();
						}
						return 0;// For failure.
					}
				});

	}

	public int getUserId(User user) {

		return jdbcTemplate.query(
				"select user_id from dbo.UserTable where firstname=" + "'" + user.getFirstname() + "'",
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user1 = new User();
							user1.setUser_id(rs.getInt(1));

							return user1.getUser_id();// This is the id of admin
						}
						return 0;// For failure.
					}
				});

	}

}
