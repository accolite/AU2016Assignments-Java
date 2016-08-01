package com.au.proma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.au.proma.model.BU;

@Repository
public class BuDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<BU> getAllBU(){
		String sql = "select * from dbo.Bu";
		return jdbcTemplate.query(sql, new RowMapper<BU>(){

			@Override
			public BU mapRow(ResultSet rs, int arg1) throws SQLException {
				BU bu = new BU();
				bu.setBuid(rs.getInt("buid"));
				bu.setBuname(rs.getString("buname"));
				return bu;
			}
		});
	}
	
	public int addBU(BU bu){
		String sql = "insert into dbo.Bu(buname) values('" + bu.getBuname() +"')";
		return jdbcTemplate.update(sql);
	}
	
}
