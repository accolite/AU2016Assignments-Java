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

import com.accolite.au.VideoPortal.model.User;
import com.accolite.au.VideoPortal.model.Video;
@Repository
public class ApprovalDAO {
 @Autowired
 private JdbcTemplate jdbcTemplate;
 public List<Video> fetchGroupRelatedVideoForUser(User user) {
  List<Video> videos = new ArrayList<>();
  // TODO Auto-generated method stub
  String query="select * from VideoTable as vT inner join GroupVideoTable as gvt on vT.video_id=gvt.video_id inner join GroupUserTable as gut on gut.group_id=gvt.video_id inner join EventTable on videoTable.event_id=EventTable.event_id where gut.user_id="+user.getUser_id()+"and vT.statusflag=0";
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

 public List<Video> fetchAllVideo(User user) {
  List<Video> videos = new ArrayList<>();
  // TODO Auto-generated method stub
  String query="  select *from VideoTable as vt inner join EventTable as et on vt.event_id=et.event_id full outer join GroupVideoTable as gvt on gvt.video_id=vt.video_id full outer join GroupTable as gt on gt.group_id=gvt.group_id where statusflag=0";
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

public List<Video> fetchGroupRelatedVideoForGroupAdmin(User user) {
	List<Video> videos = new ArrayList<>();
	  // TODO Auto-generated method stub
	  String query="  select * from VideoTable as vT inner join GroupVideoTable as gvt on vT.video_id=gvt.video_id inner join GroupAdminTable as gat on gat.group_id=gvt.group_id inner join EventTable as et on et.event_id=vT.event_id inner join GroupTable as gt on gt.group_id=gvt.group_id where gat.admin_id="+user.getUser_id()+" and  vT.statusflag=0"; 
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

}