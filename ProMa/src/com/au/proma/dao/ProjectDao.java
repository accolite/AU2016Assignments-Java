package com.au.proma.dao;
import com.au.proma.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public ArrayList<Project> statusOfEveryBU()
	{
		String query="select project.projectid,bu.buid,bu.buname,project.startdate,project.enddate, project.completed from dbo.bu left join dbo.project on bu.buid=project.buid";
		return jdbcTemplate.query(query, new ResultSetExtractor< ArrayList<Project> >() {

			public ArrayList<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				
				ArrayList<Project> temp=new ArrayList<Project>();
				while (rs.next()){
				Project project=new Project();
				Client client=new Client();
				User user=new User();
				BU bu=new BU();
				project.setProjectid(rs.getInt("projectid"));
				bu.setBuid(rs.getInt("buid"));
				bu.setBuname(rs.getString("buname"));
				project.setStartdate(rs.getDate("startdate"));
				project.setEnddate(rs.getDate("enddate"));
				project.setStatus(rs.getInt("completed"));
				project.setBu(bu);
				project.setProjectmanager(user);
				project.setClient(client);
				//Project obj=new Project(clientname, projectname, managername, resourceworking, startdate, enddate);
				temp.add(project);
				}
				return temp;
			}
		});
	}
	

	public ArrayList<Project> extractProjectsUnderBU(BU bu)
	{
		String query="select c.clientname,p.projectname,u.username,"+
"p.resourceworking,p.startdate,p.enddate from dbo.bu as bu,dbo.project as p,dbo.client as c, dbo.users"+
" as u where bu.buid='"+bu.getBuid()+ 
"' and bu.buid=p.buid " +
"and p.projectmanagerid=u.userid and c.clientid=p.clientid ";
		return jdbcTemplate.query(query, new ResultSetExtractor< ArrayList<Project> >() {

			public ArrayList<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				
				ArrayList<Project> temp=new ArrayList<Project>();
				while (rs.next()){
				Project project=new Project();
				Client client=new Client();
				User user=new User();
				BU bu=new BU();
				client.setClientname(rs.getString("clientname"));
				project.setProjectname(rs.getString("projectname"));
				user.setUsername(rs.getString("username"));
				project.setResourceworking(rs.getInt("resourceworking"));
				project.setStartdate(rs.getDate("startdate"));
				project.setEnddate(rs.getDate("enddate"));
				project.setClient(client);
				project.setBu(bu);
				project.setProjectmanager(user);
				//Project obj=new Project(clientname, projectname, managername, resourceworking, startdate, enddate);
				temp.add(project);
				}
				return temp;
			}
		});
	}
	
	
	public int updateProject(Project pobj)
	{
		String query="update dbo.project set projectmanagerid='"+ pobj.getProjectid()+"' , resourceworking='"+pobj.getResourceworking()+"' ,startdate='"+ pobj.getStartdate().toString()+"' ,enddate='"+pobj.getEnddate().toString()+"' where projectname='"+pobj.getProjectname()+"'and clientname='"+pobj.getClient().getClientname()+"'";
		return jdbcTemplate.update(query);
	}
	
	public int insertProject(Project pobj)
	{
		String query="insert into dbo.Project(projectname,clientid,projectmanagerid,buid,resourceworking,startdate,enddate)"+
                       "values('"+pobj.getProjectname()+"','"+pobj.getClient().getClientid()+"','"+pobj.getProjectmanager().getUserid()+"','"+pobj.getBu().getBuid()+"','"+pobj.getResourceworking()
                       +"','"+pobj.getStartdate().toString()+"','"+pobj.getEnddate().toString()+"')";
		return jdbcTemplate.update(query);
	}
	
	public List<Project> getAllProjects(){
		
		String sql="select * from dbo.Project";
		
		return jdbcTemplate.query(sql, new RowMapper<Project>(){

			@Override
			public Project mapRow(ResultSet arg0, int arg1) throws SQLException {
				Project p = new Project();
				
				p.setProjectname(arg0.getString("projectname"));
				return p;
			}
			
		});
		
	}
	
	
}
