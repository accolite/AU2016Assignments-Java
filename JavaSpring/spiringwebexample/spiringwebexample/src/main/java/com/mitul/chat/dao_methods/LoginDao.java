package com.mitul.chat.dao_methods;

import com.mitul.chat.dao_interface.UserDaoInterface;
import com.mitul.chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mitul Kapoor on 7/27/2016.
 */
public class LoginDao extends JdbcDaoSupport implements UserDaoInterface {

    private JdbcTemplate jdbcTemplate;

    public LoginDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(User user) {
        String sql = "INSERT INTO USER" +
                             "(USERID, NAME, PASSWORD) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, new Object[] {user.getId(),
                user.getUsername(),user.getPassword()
        });
    }

    public User verifyUserCredentials(User user) {
        String query = "SELECT * FROM USER where NAME=\'"+ user.getUsername() + "\' and PASSWORD=\'" + user.getPassword()+"\'";
        return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                User student = new User();
                while (rs.next()){
                    student.setId(rs.getString("USERID"));
                    student.setUsername(rs.getString("NAME"));
                    student.setPassword(rs.getString("PASSWORD"));
                }
                return student;
            }
        });
    }
}
