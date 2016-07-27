/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 27, 2016

*

*  @author :: Balaji P

* ***************************************************************************

*/
package com.accolite.chat.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.microsoft.sqlserver.jdbc.SQLServerResultSetMetaData;

// TODO: Auto-generated Javadoc
/**
 * The Class JdbcConnectDao.
 */
@Repository
public class JdbcConnectDao {
	
	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Gets the jdbc template.
	 *
	 * @return the jdbc template
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * Sets the jdbc template.
	 *
	 * @param jdbcTemplate the new jdbc template
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Creates the user.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the boolean
	 */
	public Boolean createUser(final String username, final String password) {
		String sql = "insert into users (username, mypassword) values(?,?)";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, username);
				ps.setString(2, password);
				return ps.execute();
			}

		});
	}

	/**
	 * Gets the password.
	 *
	 * @param username the username
	 * @return the password
	 */
	public String getPassword(final String username) {
		String sql = "select mypassword from users where username=" + username;
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String pass = null;
				while (rs.next()) {
					pass = rs.getString("mypassword");
				}
				return pass;
			}

		});

	}

	/**
	 * Start session.
	 *
	 * @param username the username
	 * @return the boolean
	 */
	public Boolean startSession(final String username) {
		String sql = "insert into active(username) values(?);";
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, username);
				return ps.execute();
			}

		});
	}

	/**
	 * Stop session.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean stopSession(final String username) {
		String sql = "delete from active where username=?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, username);
				return ps.execute();
			}

		});
	}

	/**
	 * Gets the admin password.
	 *
	 * @param username the username
	 * @return the admin password
	 */
	public String getAdminPassword(final String username) {
		String sql = "select mypassword from admin where username=" + username;
		return jdbcTemplate.query(sql, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				String pass = null;
				while (rs.next()) {
					pass = rs.getString("mypassword");
				}
				return pass;
			}

		});
	}

	/**
	 * Send message.
	 *
	 * @param username the username
	 * @param message the message
	 * @return the boolean
	 */
	public Boolean sendMessage(final String username, final String message) {
		String sql = "insert into chat (message, username) values(?,?)";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, message);
				ps.setString(2, username);
				return ps.execute();
			}

		});
	}

	/**
	 * Gets the messages.
	 *
	 * @param msgid the msgid
	 * @return the messages
	 */
	public JSONArray getMessages(int msgid) {
		String sql = "select messageid, message, username from chat where messageid > " + msgid
				+ " order by messageid asc";
		return jdbcTemplate.query(sql, new ResultSetExtractor<JSONArray>() {

			public JSONArray extractData(ResultSet rs) throws SQLException, DataAccessException {
				JSONArray json = null;

				json = resultSetToJsonObject(rs);

				return json;
			}

			public JSONArray resultSetToJsonObject(ResultSet rs) {
				JSONArray jsonArray = new JSONArray();
				JSONObject obj = null;
				SQLServerResultSetMetaData rsmd = null;
				// System.out.println(rs == null);
				try {
					rsmd = (SQLServerResultSetMetaData) rs.getMetaData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				;
				try {

					int numColumns = rsmd.getColumnCount();
					while (rs.next()) {
						obj = new JSONObject();
						for (int i = 1; i < numColumns + 1; i++) {
							String column_name = rsmd.getColumnName(i);
							// System.out.println(column_name);
							if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
								obj.put(column_name, rs.getArray(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
								obj.put(column_name, rs.getInt(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
								obj.put(column_name, rs.getBoolean(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
								obj.put(column_name, rs.getBlob(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
								obj.put(column_name, rs.getDouble(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
								obj.put(column_name, rs.getFloat(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
								// System.out.println(rs.getString(column_name));
								obj.put(column_name, rs.getInt(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.NVARCHAR) {
								obj.put(column_name, rs.getNString(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
								// System.out.println(rs.getString(column_name));
								obj.put(column_name, rs.getString(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
								obj.put(column_name, rs.getInt(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
								obj.put(column_name, rs.getInt(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
								obj.put(column_name, rs.getDate(column_name));
							} else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
								obj.put(column_name, rs.getTimestamp(column_name));
							} else {
								obj.put(column_name, rs.getObject(column_name));
							}
						}
						// System.out.println("this is:"+obj);
						jsonArray.put(obj);
						// System.out.println("this is json array:"+jsonArray);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return jsonArray;
			}

		});
	}

	/**
	 * Adds the words.
	 *
	 * @param words the words
	 */
	public void addWords(ArrayList<String> words) {
		String sql = "insert into prohwords (word) values(?)";

		final Iterator<String> iterator = words.iterator();

		while (iterator.hasNext()) {

			 jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, iterator.next());
					return ps.execute();
				}

			});

		}
	}
	
	/**
	 * Gets the words.
	 *
	 * @return the words
	 */
	public ArrayList<String> getWords(){
		String sql = "select word from  prohwords";
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<ArrayList<String>>() {

			public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> words = new ArrayList<String>();
				while (rs.next()) {
					words.add(rs.getString("word"));
				}
				return words;
			}

		});
	}
	
	/**
	 * Gets the active users.
	 *
	 * @return the active users
	 */
	public ArrayList<String> getActiveUsers(){
		String sql = "select username from active";
		return jdbcTemplate.query(sql, new ResultSetExtractor<ArrayList<String>>() {

			public ArrayList<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ArrayList<String> users = new ArrayList<String>();
				
				while (rs.next()) {
					users.add(rs.getString(1));
				}
				return users;
			}

		});
		
	}
	
}
