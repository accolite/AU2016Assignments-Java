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

import com.accolite.au.VideoPortal.Templates.GroupAdminInterface;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;

@Repository
public class GroupAdminDAO implements GroupAdminInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * Add a user to a group Returns 1 if user has been added to group Returns 0
	 * if user has not been added Returns -1 if there is an exception Returns 2
	 * if user already exists in Group
	 * 
	 */
	public int AddUser(Group group, User user) {
		int user_id = user.getUser_id();
		int group_id = group.getGroup_id();
		if (RetrieveUserFromGroup(user, group) == null) {

			String query = "Use VideoPortal INSERT into GroupUserTable (group_id,user_id) values(" + group_id + ","
					+ user_id + ")";

			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				{System.out.println(s.toString());return -1;}
			}
		} else
			return 2;
	}

	/*
	 * This function is to retrieve and return user from the group if he exists
	 * otherwise return null
	 * 
	 */
	private User RetrieveUserFromGroup(User user, Group group) {
		int id = group.getGroup_id();
		String query = "Use VideoPortal SELECT user_id FROM GroupUserTable where group_id =" + id;
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user1 = new User();
				while (rs.next()) {
					int user_id = rs.getInt("user_id");
					user1.setUser_id(user_id);
					System.out.println("user_id in jdbc:"+user_id);
					if(user.getUser_id()==user_id)
					return user1;

				}
				System.out.println("null");
				return null;

			}
		});

	}

	/*
	 * This function is to remove a user from the group Returns 1 if user has
	 * been removed from group Returns 0 if user has not been removed Returns -1
	 * if there is an exception Returns 2 if user is not a member of the Group
	 */
	public int RemoveUser(Group group, User user) {
		int id = group.getGroup_id();
		if (RetrieveUserFromGroup(user, group) != null) {
			String query = "Use VideoPortal Delete from GroupUserTable where user_id='" + user.getUser_id() + "'";
			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				return -1;
			}
		}
		return 2;
	}

	/*
	 * This function is to approve a video by groupadmin Returns 1 if video has
	 * been approved Returns 0 if user has not been approved Returns -1 if there
	 * is an exception Returns 2 if video doesn't exist
	 */
	public int ApproveVideo(Video video, User admin) {
		int user_id = admin.getUser_id();
		if (RetrieveVideo(video) != null) {
			String query = "Use VideoPortal Update VideoTable set statusflag=1,Approval_id=" + user_id
					+ "where video_id=" + video.getVideo_id() ;
			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				System.out.println(s.toString());return -1;
			}

		}
		return 2;
	}
	 public int RejectVideo(Video video, User admin) {
		  int user_id = admin.getUser_id();
		  if (RetrieveVideo(video) != null) {
		   String query = "Use VideoPortal delete from VideoTable where video_id=" + video.getVideo_id() ;
		   try {
		    if (jdbcTemplate.update(query) > 0)
		     return 1;
		    else
		     return 0;
		   } catch (DataAccessException s) {
		    return -1;
		   }

		  }
		  return 2;
		 }
	/*
	 * This function is to retrieve and return video from the database if video
	 * exists otherwise return null
	 * 
	 */
	public Video RetrieveVideo(Video video) {
		int id = video.getVideo_id();
		String query = "Use VideoPortal SELECT video_id FROM VideoTable where video_id ='" + id + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

			public Video extractData(ResultSet rs) throws SQLException, DataAccessException {
				Video video1 = new Video();
				while (rs.next()) {
					int video_id = rs.getInt("video_id");
					video1.setVideo_id(video_id);
					return video1;

				}
				return null;

			}
		});

	}

	public User isGroupAdmin(User user) {
		int id = user.getUser_id();
		String query = "Select * from GroupAdmintable where admin_id='" + id + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user1 = new User();
				while (rs.next()) {
					int user_id = rs.getInt("user_id");
					user1.setUser_id(user_id);
					return user1;

				}
				return null;

			}
		});

	}

	public int getUserId(User user) {

		return jdbcTemplate.query(
				"select user_id from dbo.UserTable where firstname like " + "'" + user.getFirstname() + "'",
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user1 = new User();
							user1.setUser_id(rs.getInt(1));

							return user1.getUser_id();// This is the id of the
														// user added to group
														// by admin
						}
						return 0;// For failure.
					}
				});

	}
	
	public int getUserIdBasedOnEmail(User user) {

		return jdbcTemplate.query(
				"select user_id from dbo.UserTable where email_id like " + "'" + user.getEmail_id() + "'",
				new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

						while (rs.next()) {
							User user1 = new User();
							user1.setUser_id(rs.getInt(1));

							return user1.getUser_id();// This is the id of the
														// user added to group
														// by admin
						}
						return 0;// For failure.
					}
				});

	}
	public int getGroupIdByName(String group_name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select group_id from GroupTable where groupname like " + "'" + group_name + "'",
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

	public List<Group> listGroups(User user) {
		// TODO Auto-generated method stub

			String query="Select * from GroupAdminTable as gat inner join GroupTable as gt on gt.group_id=gat.group_id and gat.admin_id="+user.getUser_id();
			return jdbcTemplate.query(query, new ResultSetExtractor<List<Group>>() {
				
				List<Group> groups = new ArrayList<Group>();
				public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					while (rs.next()) {
						Group group=new Group();
						group.setGroup_id(rs.getInt("group_id"));
						group.setName(rs.getString("groupname"));
						groups.add(group);
					}
					
					return groups;

				}
			});
		

	}

	public List<Group> listGroupsOfUser(User user) {
		String query="Select * from GroupUserTable as gut inner join GroupTable as gt on gt.group_id=gut.group_id and gut.user_id="+user.getUser_id();
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Group>>() {
			
			List<Group> groups = new ArrayList<Group>();
			public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while (rs.next()) {
					Group group=new Group();
					group.setGroup_id(rs.getInt("group_id"));
					group.setName(rs.getString("groupname"));
					groups.add(group);
				}
				
				return groups;

			}
		});
	

	}

	public Group FindGroupWithName(String groupname) {
		// TODO Auto-generated method stub
		String query="Select * from GroupTable as gt where gt.groupname='"+groupname+"'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Group>() {

			public Group extractData(ResultSet rs) throws SQLException, DataAccessException {
				Group group = new Group();
				while (rs.next()) {
					group.setGroup_id(rs.getInt("group_id"));
					group.setName(rs.getString("groupname"));
					
					return group;

				}
				return null;

			}
		});
	}

	
	
}

/*package com.accolite.au.VideoPortal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.au.VideoPortal.Templates.GroupAdminInterface;
import com.accolite.au.VideoPortal.model.Event;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;

@Repository
public class GroupAdminDAO implements GroupAdminInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	 * Add a user to a group Returns 1 if user has been added to group Returns 0
	 * if user has not been added Returns -1 if there is an exception Returns 2
	 * if user already exists in Group
	 * 
	 
	public int AddUser(Group group, User user) {
		int user_id = user.getUser_id();
		int group_id = group.getGroup_id();
		if (RetrieveUserFromGroup(user, group) == null) {

			String query = "Use VideoPortal INSERT into GroupUserTable (group_id,user_id) values(" + group_id + ","
					+ user_id + ")";

			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				{System.out.println(s.toString());return -1;}
			}
		} else
			return 2;
	}

	
	 * This function is to retrieve and return user from the group if he exists
	 * otherwise return null
	 * 
	 
	private User RetrieveUserFromGroup(User user, Group group) {
		int id = group.getGroup_id();
		String query = "Use VideoPortal SELECT user_id FROM GroupUserTable where group_id =" + id;
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user1 = new User();
				while (rs.next()) {
					int user_id = rs.getInt("user_id");
					user1.setUser_id(user_id);
					System.out.println("user_id in jdbc:"+user_id);
					if(user.getUser_id()==user_id)
					return user1;

				}
				System.out.println("null");
				return null;

			}
		});

	}

	
	 * This function is to remove a user from the group Returns 1 if user has
	 * been removed from group Returns 0 if user has not been removed Returns -1
	 * if there is an exception Returns 2 if user is not a member of the Group
	 
	public int RemoveUser(Group group, User user) {
		int id = group.getGroup_id();
		if (RetrieveUserFromGroup(user, group) != null) {
			String query = "Use VideoPortal Delete from GroupUserTable where user_id='" + user.getUser_id() + "'";
			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				return -1;
			}
		}
		return 2;
	}

	
	 * This function is to approve a video by groupadmin Returns 1 if video has
	 * been approved Returns 0 if user has not been approved Returns -1 if there
	 * is an exception Returns 2 if video doesn't exist
	 
	public int ApproveVideo(Video video, User admin) {
		int user_id = admin.getUser_id();
		if (RetrieveVideo(video) != null) {
			String query = "Use VideoPortal Update VideoTable set statusflag=1,Approval_id=" + user_id
					+ "where video_id=" + video.getVideo_id() ;
			try {
				if (jdbcTemplate.update(query) > 0)
					return 1;
				else
					return 0;
			} catch (DataAccessException s) {
				System.out.println(s.toString());return -1;
			}

		}
		return 2;
	}
	 public int RejectVideo(Video video, User admin) {
		  int user_id = admin.getUser_id();
		  if (RetrieveVideo(video) != null) {
		   String query = "Use VideoPortal delete from VideoTable where video_id=" + video.getVideo_id() ;
		   try {
		    if (jdbcTemplate.update(query) > 0)
		     return 1;
		    else
		     return 0;
		   } catch (DataAccessException s) {
		    return -1;
		   }

		  }
		  return 2;
		 }
	
	 * This function is to retrieve and return video from the database if video
	 * exists otherwise return null
	 * 
	 
	public Video RetrieveVideo(Video video) {
		int id = video.getVideo_id();
		String query = "Use VideoPortal SELECT video_id FROM VideoTable where video_id ='" + id + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

			public Video extractData(ResultSet rs) throws SQLException, DataAccessException {
				Video video1 = new Video();
				while (rs.next()) {
					int video_id = rs.getInt("video_id");
					video1.setVideo_id(video_id);
					return video1;

				}
				return null;

			}
		});

	}

	public User isGroupAdmin(User user) {
		int id = user.getUser_id();
		String query = "Select * from GroupAdmintable where admin_id='" + id + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user1 = new User();
				while (rs.next()) {
					int user_id = rs.getInt("user_id");
					user1.setUser_id(user_id);
					return user1;

				}
				return null;

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

							return user1.getUser_id();// This is the id of the
														// user added to group
														// by admin
						}
						return 0;// For failure.
					}
				});

	}
	public int getGroupIdByName(String group_name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select group_id from GroupTable where groupname='" + group_name+"'",
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

	public List<Group> listGroups(User user) {
		// TODO Auto-generated method stub

			String query="Select * from GroupAdminTable as gat inner join GroupTable as gt on gt.group_id=gat.group_id and gat.admin_id="+user.getUser_id();
			return jdbcTemplate.query(query, new ResultSetExtractor<List<Group>>() {
				
				List<Group> groups = new ArrayList<Group>();
				public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
					Group group=new Group();
					while (rs.next()) {
						
						group.setGroup_id(rs.getInt("group_id"));
						group.setName(rs.getString("groupname"));
					}
					groups.add(group);
					return groups;

				}
			});
		

	}

	public List<Group> listGroupsOfUser(User user) {
		String query="Select * from GroupUserTable as gut inner join GroupTable as gt on gt.group_id=gut.group_id and gut.user_id="+user.getUser_id();
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Group>>() {
			
			List<Group> groups = new ArrayList<Group>();
			public List<Group> extractData(ResultSet rs) throws SQLException, DataAccessException {
				Group group=new Group();
				while (rs.next()) {
					
					group.setGroup_id(rs.getInt("group_id"));
					group.setName(rs.getString("groupname"));
				}
				groups.add(group);
				return groups;

			}
		});
	

	}

}
*/