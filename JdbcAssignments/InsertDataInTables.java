package org.au.workshop.domain;

import java.sql.*;
import java.util.ArrayList;

import org.au.workshop.util.Constants;

public class InsertDataInTables {
	public static void main(String...strings){
		Connection conn = null;
		Statement stmt = null;
	    try {
			Class.forName(Constants.JTDS_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL,Constants.userName,Constants.password);
			stmt = conn.createStatement();
			ArrayList<String> query = new ArrayList<String>();
			query.add("use Database1 insert into President(ssn,name,age) values(1,'vishal goyal',21)");
			query.add("use Database1 insert into State(id,name) values(1,'madhya pradesh')");
			query.add("use Database1 insert into State(id,name) values(2,'aandhra pradesh')");
			query.add("use Database1 insert into State(id,name) values(4,'uttar pradesh')");
			query.add("use Database1 insert into District(id,state_id,head_ssn,name) values(1,2,3,'bhopal')");
			query.add("use Database1 insert into District(id,state_id,head_ssn,name)  values(2,2,4,'gwalior')");
			query.add("use Database1 insert into District(id,state_id,head_ssn,name)  values(3,4,1,'agra')");
			query.add("use Database1 insert into District(id,state_id,head_ssn,name)  values(4,4,5,'aligarh')");
			query.add("use Database1 insert into District(id,state_id,head_ssn,name)  values(5,2,2,'hyderabad')");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(1,3,'r',50,1)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(2,5,'ramiz',40,1)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(3,1,'rahul',35,1)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(4,2,'ram',50,1)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(5,4,'raja',40,1)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(6,1,'rani',40,0)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(7,2,'mitul',70,0)");
			query.add("use Database2 insert into Citizen(ssn,district_id,name,age,is_vip) values(8,1,'vishal',21,0)");
			for(int i=0; i<query.size(); i++)
				stmt.addBatch(query.get(i));
			stmt.executeBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
