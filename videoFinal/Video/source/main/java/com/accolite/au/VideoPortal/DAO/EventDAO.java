package com.accolite.au.VideoPortal.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.accolite.au.VideoPortal.Templates.EventInterface;
import com.accolite.au.VideoPortal.model.Comment;
import com.accolite.au.VideoPortal.model.Event;
@Repository
public class EventDAO implements EventInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int CreateEvent(Event event) {

		/*String query = "insert into EventTable(eventname,dateOfEvent) values ('" + event.getEvent_name()
				+ "',GETDATE())";*/
	//	+ "','"+event.getDateOfEvent()+"'";
		String query = "insert into EventTable(eventname,dateOfEvent) values ('" + event.getEvent_name()
	    + "',CAST('"+event.getDateOfEvent()+"' AS Date))";
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
	public int DeleteEvent(Event event) {

		String query = "delete from EventTable where eventname = '" + event.getEvent_name()+"'";

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
	public Event RetrieveEvent(String eventName) {

		String query = "select * from EventTable where eventname ='" + eventName+"'";

		return jdbcTemplate.query(query, new ResultSetExtractor<Event>() {

			public Event extractData(ResultSet rs) throws SQLException, DataAccessException {

				while (rs.next()) {

					Event event = new Event();

					event.setEvent_id(rs.getInt(1));
					event.setEvent_name(rs.getString(2));
					event.setDateOfEvent(rs.getDate(3));
					return event;
				}
				return null;

			}
		});
	}

}
