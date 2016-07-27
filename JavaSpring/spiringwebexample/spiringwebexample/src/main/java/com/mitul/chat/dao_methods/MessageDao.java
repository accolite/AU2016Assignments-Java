package com.mitul.chat.dao_methods;

import com.mitul.chat.dao_interface.MessagesDaoInterface;
import com.mitul.chat.model.MessageHelper;
import com.mitul.chat.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitul Kapoor on 7/27/2016.
 */
public class MessageDao implements MessagesDaoInterface{


    private JdbcTemplate jdbcTemplate;

    public MessageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insertMessage(String message, Date date,String user) {
        String sql = "INSERT INTO Message (message, date, user) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, new Object[] {message,date,user});
    }

    public List<MessageHelper> getAllMessages() {
        String query = "SELECT * FROM Message";
        return jdbcTemplate.query(query, new ResultSetExtractor<List<MessageHelper>>() {
            public List<MessageHelper> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<MessageHelper> messageList = new ArrayList<MessageHelper>();
                MessageHelper student = new MessageHelper();
                while (rs.next()){
                    student.setMessage(rs.getString("message"));
                    student.setDate(rs.getDate("date"));
                    student.setUser(rs.getString("user"));
                    messageList.add(student);
                }
                return messageList;
            }
        });
    }

}
