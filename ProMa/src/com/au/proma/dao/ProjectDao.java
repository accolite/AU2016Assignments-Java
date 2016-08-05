package com.au.proma.dao;

import com.au.proma.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

	final private String base_query_for_getting_project = "select * from project,bu,user,client,role where bu.buid = project.buid and user.userid = project.projectmanagerid"
			+ " and client.clientid = project.clientid and user.userroleid = role.roleid";

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public ArrayList<Project> statusOfEveryBU() {
		String query = "select project.projectid,bu.buid,bu.buname,project.startdate,project.enddate, project.completed from dbo.bu left join dbo.project on bu.buid=project.buid";
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Project>>() {

			public ArrayList<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {

				ArrayList<Project> temp = new ArrayList<Project>();
				while (rs.next()) {
					Project project = getProjectFromResultSet(rs);
					temp.add(project);
				}
				return temp;
			}
		});
	}

	public ArrayList<Project> extractProjectsUnderBU(BU bu) {
		String query = base_query_for_getting_project + "and bu.buid = "+bu.getBuid();
		return jdbcTemplate.query(query, new ResultSetExtractor<ArrayList<Project>>() {

			public ArrayList<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {

				ArrayList<Project> temp = new ArrayList<Project>();
				while (rs.next()) {
					Project project = getProjectFromResultSet(rs);
					temp.add(project);
				}
				return temp;
			}
		});
	}

	public int updateProject(Project pobj) {
		String query = "update dbo.project set projectmanagerid=?,resourceworking=?,startdate=?,enddate=?,completed=?"
				+ "buid=?,clientid=?,projectname = ? where projectid=?" ;
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement stmt = arg0.prepareStatement(query);
				stmt.setString(8, pobj.getProjectname());
				stmt.setInt(6, pobj.getClient().getClientid());
				stmt.setInt(1, pobj.getProjectmanager().getUserid());
				stmt.setInt(5, pobj.getBu().getBuid());
				stmt.setInt(2, pobj.getResourceworking());
				stmt.setDate(3, pobj.getStartdate());
				stmt.setDate(4, pobj.getEnddate());
				stmt.setInt(5, pobj.getCompleted());
				stmt.setInt(9, pobj.getProjectid());
				return stmt;
			}
		};
		return jdbcTemplate.update(psc);
	}

	public int insertProject(Project pobj) {
		String query = "insert into dbo.Project(projectname,clientid,projectmanagerid,buid,resourceworking,startdate,enddate,completed)"
				+ "values(?,?,?,?,?,?,?,?)";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection arg0) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement stmt = arg0.prepareStatement(query);
				stmt.setString(1, pobj.getProjectname());
				stmt.setInt(2, pobj.getClient().getClientid());
				stmt.setInt(3, pobj.getProjectmanager().getUserid());
				stmt.setInt(4, pobj.getBu().getBuid());
				stmt.setInt(5, pobj.getResourceworking());
				stmt.setDate(6, pobj.getStartdate());
				stmt.setDate(7, pobj.getEnddate());
				stmt.setInt(8, pobj.getCompleted());
				return stmt;
			}
		};
		return jdbcTemplate.update(psc);
	}

	public List<Project> getAllProjects() {

		String sql = "select * from project,bu,user,client,role where bu.buid = project.buid and user.userid = project.projectmanagerid"
				+ " and client.clientid = project.clientid and user.userroleid = role.roleid";

		return jdbcTemplate.query(sql, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet arg0, int arg1) throws SQLException {
				return getProjectFromResultSet(arg0);
			}

		});
	}

	public Project getProject(int projectid) {

		String sql = base_query_for_getting_project + "and project.projectid = " + projectid;

		return jdbcTemplate.queryForObject(sql, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet arg0, int arg1) throws SQLException {
				return getProjectFromResultSet(arg0);
			}

		});
	}
	
	public int deleteProject(int projectid){
		String sql = "delete from project where projectid = "+projectid;
		return jdbcTemplate.update(sql);
	}

	public Project getProjectFromResultSet(ResultSet arg0) throws SQLException {
		Client client = new Client(arg0.getInt("clientid"), arg0.getString("clientname"));
		BU bu = new BU(arg0.getInt("buid"), arg0.getString("buname"));
		Role role = new Role(arg0.getInt("roleid"), arg0.getString("rolename"));
		User projectManager = new User(arg0.getInt("userid"), arg0.getString("username"), arg0.getString("useremail"),
				arg0.getString("userroleid"), role);
		Project p = new Project(arg0.getInt("projectid"), client, arg0.getString("projectname"), projectManager,
				arg0.getInt("resourceworking"), arg0.getDate("startdate"), arg0.getDate("enddate"), 0, bu,arg0.getInt("completed"));
		return p;
	}
}
