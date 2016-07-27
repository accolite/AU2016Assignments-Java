package com.accolite.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.accolite.java.Message;


public class MessageDao{


    private JdbcTemplate jdbcTemplate;

    public MessageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(String message, String user) {
        String sql = "INSERT INTO message (message, user) VALUES (?, ?)";

        jdbcTemplate.update(sql, new Object[] {message,user});
    }

    public List<Message> getAllMessages() {
        String query = "SELECT * FROM message";
        return jdbcTemplate.query(query, new ResultSetExtractor<List<Message>>() {
            public List<Message> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Message> messageList = new ArrayList<Message>();
                Message student = new Message();
                while (rs.next()){
                    student.setMessage(rs.getString("message"));
                    student.setUsername(rs.getString("username"));
                    messageList.add(student);
                }
                return messageList;
            }
        });
    }

}