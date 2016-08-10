package com.accolite.au.VideoPortal.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.au.VideoPortal.Templates.VideoInterface;
import com.accolite.au.VideoPortal.model.Comment;
import com.accolite.au.VideoPortal.model.Event;
import com.accolite.au.VideoPortal.model.Group;
import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;

@Repository
public class VideoDAO implements VideoInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @Override
	// public int AddVideo(Video video, Group group, User user) {
	//
	// String query = "insert into
	// VideoTable(user_id,Approval_id,Privacy,Title,Topic,event_id,statusflag,url)
	// values " + "('" + video.getUser_id() + "','" + video.getApproval_id()
	// + "','" + video.getPrivacy() + "','" + video.getTitle() + "','" +
	// video.getTopic() + "','"
	// + video.getEvent_id() + "','" + video.getStatusFlag() + "','" +
	// video.getUrl() + "')";
	//
	// try {
	// if (jdbcTemplate.update(query) > 0)
	// return 1;
	// else
	// return 0;
	// } catch (DataAccessException e) {
	// return -1;
	// }
	//
	// }

	public List<Video> SearchByGroup(Group group) {
		  // TODO Auto-generated method stub
		  List<Video> videos = new ArrayList<Video>();
		 /* String query = " select * from GroupVideoTable as groupvideoTable inner join VideoTable as videoTable on groupvideoTable.video_id=videoTable.video_id where groupvideoTable.group_id="
		    + group.getGroup_id();*/
		  String query ="select * from GroupVideoTable as groupvideoTable inner join VideoTable as videoTable on groupvideoTable.video_id=videoTable.video_id inner join EventTable on videoTable.event_id=EventTable.event_id inner join GroupTable as gt on gt.group_id=groupvideoTable.group_id where groupvideoTable.group_id="+group.getGroup_id();
		  return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

		   public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

		    while (rs.next()) {
		     Video video = new Video();
		     video.setVideo_id(rs.getInt("video_id"));
		     video.setTitle(rs.getString("Title"));
		     video.setTopic(rs.getString("Topic"));
		     video.setApproval_id(rs.getInt("Approval_id"));
		     video.setEvent_id(rs.getInt("event_id"));
		     video.setPrivacy(rs.getString("Privacy"));
		     video.setUser_id(rs.getInt("user_id"));
		     video.setStatusFlag(rs.getInt("statusFlag"));
		     video.setUrl(rs.getString("url"));
		     video.setGroupname(rs.getString("groupname"));
		     video.setEventname(rs.getString("eventname"));
		     video.setDateOfEvent(rs.getDate("dateOfEvent"));
		     videos.add(video);
		    }
		    return videos;

		   }
		  });
		  
		 }
	
	@Override
	public List<Video> PublicVideos() {

		List<Video> videos = new ArrayList<Video>();
		
		String query = "  select * from VideoTable as vt inner join EventTable as et on vt.event_id=et.event_id full outer join GroupVideoTable as gvt on gvt.video_id=vt.video_id full outer join GroupTable as gt on gt.group_id=gvt.group_id  where privacy like 'public' and statusflag=1";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					   video.setEventname(rs.getString("eventname"));
					     video.setDateOfEvent(rs.getDate("dateOfEvent"));
					videos.add(video);
				}
				return videos;

			}
		});
	}
	@Override
	 public int AddVideo(Video video,User user) {
		System.out.println("In DAO");
		System.out.println("user_id"+user.getUser_id());
		System.out.println("getTopic "+video.getTopic());
		System.out.println("getEvent_id "+video.getEvent_id());
		System.out.println("getUrl "+video.getUrl());
		System.out.println("getPrivacy "+video.getPrivacy());
		System.out.println("getStatusFlag "+video.getStatusFlag());
		System.out.println("getApproval_id "+video.getApproval_id());
	  String query = "insert into VideoTable (user_id,Privacy,Title,Topic,event_id,statusflag,url)values " 
	      + "(" + user.getUser_id() + "," + "'" + video.getPrivacy() + "'" + ","  + "'"+ 
	      video.getTitle() + "'" + "," + "'" + video.getTopic() + "'" + "," + 
	      video.getEvent_id() + "," + video.getStatusFlag() + ",'" + video.getUrl() + "'" +")";

//insert into VideoTable (user_id,Privacy,Title,Topic,event_id,statusflag,url) 
//values(3,'Private','A','B',1,0,'https://www.youtube.com/embed/qp3nFT5S4LM')
	  try {
	   if (jdbcTemplate.update(query) > 0)
	    {System.out.println("1");return 1;}
	   else
	    {System.out.println("0");return 0;}
	  } catch (DataAccessException e) {
		  System.out.println("-1");
		  System.out.println(e.toString());return -1;
	  }

	 }

	@Override
	public int CreateGroupVideoTableEntry(Video video, Group group, User user) {

		String query = "insert into GroupVideoTable values " + "('" + group.getGroup_id() + "','" + video.getVideo_id()
				+ "', GETDATE())";

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
	public int DeleteVideo(Video video) {

		int videoId = video.getVideo_id();
		String query = "delete from VideoTable where video_id = " + videoId;

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
	public int AddComment(Video video, Comment comment, User user) {

		String query = "insert into CommentsTable(user_id,video_id,comment_description, comment_time) values " + "('"
				+ comment.getUser_id() + "','" + comment.getVideo_id() + "','" + comment.getComment_desc() + "','"
				+ comment.getTime() + "')";

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
	public List<Comment> ViewComments(Video video) {
		int video_id = video.getVideo_id();
		List<Comment> comments = null;
		String query = "Select * from CommentsTable as commentsTable.video_id=" + video_id;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Comment>>() {

			public List<Comment> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Comment comment = new Comment();
					comment.setComment_desc(rs.getString("comment_description"));
					comment.setComment_id(rs.getInt("comment_id"));
					comment.setTime(rs.getTime("comment_time"));
					comment.setUser_id(rs.getInt("user_id"));
					comment.setVideo_id(rs.getInt("video_id"));

					comments.add(comment);
				}
				return comments;

			}
		});
	}

	@Override
	public List<Video> UserSearchVideoByTitle(String title, User user) {

		int user_id = user.getUser_id();

		List<Video> videos = null;
		String query = "select * from VideoTable as vt inner join GroupVideoTable as gvt on vt.video_id=gvt.video_id  inner join GroupUserTable as gut on gvt.group_id=gut.group_id inner join UserTable as ut on gut.user_id=ut.user_id where vt.title='"
				+ title + "'and gut.user_id=" + user_id;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> UserSearchVideoByTopic(String topic, User user) {
		int user_id = user.getUser_id();

		List<Video> videos = null;
		String query = "select * from VideoTable as vt inner join GroupVideoTable as gvt on vt.video_id=gvt.video_id  inner join GroupUserTable as gut on gvt.group_id=gut.group_id inner join UserTable as ut on gut.user_id=ut.user_id where vt.topic='"
				+ topic + "' and gut.user_id=" + user_id;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> UserSearchVideoByEvent(String event_name, User user) {
		int user_id = user.getUser_id();
		List<Video> videos = null;
		String query = "select * from GroupUserTable as groupUserTable inner join GroupVideoTable as groupVideoTable on groupUserTable.group_id=groupVideoTable.group_id  inner join VideoTable as videoTable on groupVideoTable.video_id=videoTable.video_id inner join EventTable as eventTable on videoTable.event_id=eventTable.event_name where groupusertable.user_id="
				+ user_id + " and eventTable.event_name='" + event_name + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> UserSearchVideoByDateOfAddition(Date date, User user) {
		int user_id = user.getUser_id();
		List<Video> videos = null;
		String query = "select * from GroupUserTable as groupusertable inner join GroupVideoTable as groupvideotable on groupusertable.group_id=groupvideotable.group_id  inner join VideoTable as videotable on groupvideotable.video_id=videotable.video_id where groupusertable.user_id="
				+ user_id + " and groupvideotable.creation_time=" + date;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> UserSearchVideoByDateOfEvent(Date date, User user) {
		int user_id = user.getUser_id();
		List<Video> videos = null;
		String query = "select * from GroupUserTable as groupUserTable inner join GroupVideoTable as groupVideoTable on groupUserTable.group_id=groupVideoTable.group_id inner join VideoTable as videoTable on groupVideoTable.video_id=videoTable.video_id inner join EventTable as eventTable on eventTable.event_id=VideoTable.event_id where groupUserTable.user_id="
				+ user_id + " and EventTable.dateOfEvent=" + date;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> AdminSearchVideoByTitle(String title, User user) {
		int user_id = user.getUser_id();

		List<Video> videos = null;
		String query = "select * from VideoTable vt.title=" + "'" + title + "'";

		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> AdminSearchVideoByTopic(String topic, User user) {
		int user_id = user.getUser_id();

		List<Video> videos = null;
		String query = "select * from VideoTable vt.topic=" + "'" + topic + "'";

		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> AdminSearchVideoByEvent(String event_name, User user) {
		List<Video> videos = null;
		String query = "select * from VideoTable as videoTable inner join EventTable as eventTable on videoTable.event_id=eventTable.event_id where eventTable.event_name='"
				+ event_name + "'";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> AdminSearchVideoByDateOfAddition(Date date) {
		List<Video> videos = null;
		String query = " select * from VideoTable as videoTable inner join GroupVideoTable as groupVideoTable on videoTable.video_id=groupVideoTable.video_id where groupVideoTable.creation_time="
				+ date;
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public List<Video> AdminSearchVideoByDateOfEvent(Date date) {
		List<Video> videos = null;
		String query = " select * from VideoTable as videoTable inner join EventTable as eventTable on videoTable.event_id=eventTable.event_id where eventTable.DateOfEvent="
				+ date;

		return jdbcTemplate.query(query, new ResultSetExtractor<List<Video>>() {

			public List<Video> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					videos.add(video);
				}
				return videos;

			}
		});
	}

	@Override
	public Video PlayVideo(Video video) {

		String url = video.getUrl();

		String query = "select * from VideoTable where url=" + url;

		return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

			public Video extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					Video video = new Video();
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					return video;
				}
				return null;

			}
		});

	}

	
	 public int getVideoId(Video video) {
	  
	  return jdbcTemplate.query("select video_id from VideoTable where Title='"+ video.getTitle() + "'" , new ResultSetExtractor<Integer>() {

	   @Override
	   public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

	    while (rs.next()) {
	     Video video = new Video();
	     video.setVideo_id(rs.getInt(1));
	     return video.getVideo_id();//for success
	    }

	    return 0;//for failure.
	   }
	  });
	 }
	  public boolean AddVideoToGroup(Group group, Video video) {
		   
		   String query = "insert into GroupVideoTable values " + "(" + group.getGroup_id() + "," 
		       + video.getVideo_id()+",GETDATE())";

		   try {
		    if (jdbcTemplate.update(query) > 0)
		     {System.out.println("fgfg");return true;}
		    else
		    {System.out.println("fgfg false");return false;}
		   } catch (DataAccessException e) {
		    System.out.println(e.toString());
		    System.out.println("fgfg1");
		    return false;
		   }
		   
		  }
	
	public Video RetrieveVideo(int video_id) {
		String query = " select * from VideoTable where video_id="+video_id; 
		Video video = new Video();

		return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

			public Video extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					
					video.setVideo_id(rs.getInt("video_id"));
					video.setTitle(rs.getString("Title"));
					video.setTopic(rs.getString("Topic"));
					video.setApproval_id(rs.getInt("Approval_id"));
					video.setEvent_id(rs.getInt("event_id"));
					video.setPrivacy(rs.getString("Privacy"));
					video.setUser_id(rs.getInt("user_id"));
					video.setStatusFlag(rs.getInt("statusFlag"));
					video.setUrl(rs.getString("url"));
					
				}
				return video;

			}
		});
		
	}

	public User RetrieveEmailOfUserWhoAddedVideo(Video video) {
		// TODO Auto-generated method stub
		String query="Select * from VideoTable as vt inner join UserTable as ut on vt.user_id=ut.user_id where video_id="+video.getVideo_id();
		return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
			User user=new User();
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {
					
					user.setEmail_id(rs.getString("user_id"));
					user.setFirstname(rs.getString("firstname"));
					user.setLastname(rs.getString("lastname"));
					user.setEmail_id(rs.getString("email_id"));
					
				}
				System.out.println("user.gert "+user.getEmail_id());
				return user;

			}
		});
		
	}

	public List<Event> fetchingEvents() {
		String query="Select * from EventTable";
		return jdbcTemplate.query(query, new ResultSetExtractor<List<Event>>() {
			
			List<Event> events = new ArrayList<Event>();
			public List<Event> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				while (rs.next()) {
					Event event=new Event();
					event.setDateOfEvent(rs.getDate("dateOfEvent"));
					event.setEvent_id(rs.getInt("event_id"));
					event.setEvent_name(rs.getString("eventname"));
					events.add(event);
				}
				//System.out.println("event date "+event.getDateOfEvent());
				return events;

			}
		});
	}
	
	public Video SearchForDuplicatePrivate(String url,String groupname)
	 {
	  String query ="  select * from GroupVideoTable as groupvideoTable full outer join VideoTable as videoTable on groupvideoTable.video_id=videoTable.video_id where groupvideoTable.groupname="+groupname+"and url='"+"'"+url;
	  return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

	     public Video extractData(ResultSet rs) throws SQLException, DataAccessException {
	      Video video = new Video();
	      while (rs.next()) {
	        
	       video.setVideo_id(rs.getInt("video_id"));
	       video.setTitle(rs.getString("Title"));
	       video.setTopic(rs.getString("Topic"));
	       video.setApproval_id(rs.getInt("Approval_id"));
	       video.setEvent_id(rs.getInt("event_id"));
	       video.setPrivacy(rs.getString("Privacy"));
	       video.setUser_id(rs.getInt("user_id"));
	       video.setStatusFlag(rs.getInt("statusFlag"));
	       video.setUrl(rs.getString("url"));
	      
	      }
	      return video;

	     }
	    });
	    
	  
	 }
	 public Video SearchForDuplicatePublic(String url)
	 {
	  String query ="  select * from  VideoTable  where url='"+url+"'";
	  return jdbcTemplate.query(query, new ResultSetExtractor<Video>() {

	     public Video extractData(ResultSet rs) throws SQLException, DataAccessException {
	      Video video = new Video();
	      while (rs.next()) {
	        
	       video.setVideo_id(rs.getInt("video_id"));
	       video.setTitle(rs.getString("Title"));
	       video.setTopic(rs.getString("Topic"));
	       video.setApproval_id(rs.getInt("Approval_id"));
	       video.setEvent_id(rs.getInt("event_id"));
	       video.setPrivacy(rs.getString("Privacy"));
	       video.setUser_id(rs.getInt("user_id"));
	       video.setStatusFlag(rs.getInt("statusFlag"));
	       video.setUrl(rs.getString("url"));
	      
	      }
	      return video;

	     }
	    });
	    
	  
	 }
}
	