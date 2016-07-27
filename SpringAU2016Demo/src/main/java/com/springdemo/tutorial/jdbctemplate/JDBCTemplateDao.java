package com.springdemo.tutorial.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCTemplateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Student getStudent(Integer id){
		String query = "SELECT STUDENT_ID,STUDENT_NAME FROM Student where"
				+ " STUDENT_ID = "+id;
		return jdbcTemplate.query(query, new ResultSetExtractor<Student>() {

			public Student extractData(ResultSet rs) throws SQLException, DataAccessException {
				Student student = new Student();
				while (rs.next()){
				
				student.setStudentId(rs.getInt("STUDENT_ID"));
				student.setStudentName(rs.getString("STUDENT_NAME"));
				}
				return student;
			}
		});
	}
	
	public int saveStudent(Student student){
		String query = "insert into Student(STUDENT_ID,STUDENT_NAME) values "
				+ "("+student.getStudentId()+",'"+student.getStudentName()+"')";		
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveStudentUsingPreparedStatement(final Student student){
		String query = "insert into Student(STUDENT_ID,STUDENT_NAME) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setInt(1, student.getStudentId());
				ps.setString(2, student.getStudentName());
				return ps.execute();
			}
		});
	}
	
}
