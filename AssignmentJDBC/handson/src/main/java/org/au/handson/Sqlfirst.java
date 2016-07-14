/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 14, 2016

*

*  @author :: Nishant Adhikari

* ***************************************************************************

*/
package org.au.handson;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Sqlfirst {
	
	/** The pstmt. */
	PreparedStatement pstmt = null;
	static Connection conn = null;
	Statement stmt=null;
	ResultSet rs = null;
	HashMap<Integer,Integer> vip;
	HashMap<Integer,Integer> viprelation;
	public void vipcompute(){
		try{
			vip=new HashMap<Integer,Integer>();
			viprelation=new HashMap<Integer,Integer>();
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			vip.clear();
			viprelation.clear();
			pstmt=conn.prepareStatement("select * from temp.dbo.president");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vip.put(rs.getInt(1),1);
			}
			pstmt=conn.prepareStatement("select Head from temp.dbo.Diststate");
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vip.put(rs.getInt(1),1);
			}
			pstmt=conn.prepareStatement("select * from temp.dbo.Relation");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				if(vip.containsKey(rs.getInt(1))){
					viprelation.put(rs.getInt(2),2);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void flush(){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			
			pstmt=conn.prepareStatement("delete from ?");
			pstmt.setString(1,"temp.dbo.State");
			
			pstmt.addBatch();
			pstmt.setString(1,"temp.dbo.District");
			pstmt.addBatch();
			/*
			pstmt.setString(1,"temp.dbo.Diststate");
			pstmt.addBatch();
			pstmt.setString(1,"temp2.dbo.Citizen");
			pstmt.addBatch();
			*/
			pstmt.executeBatch();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Inits the.
	 */
	public void init(){
		vip=new HashMap<Integer,Integer>();
		viprelation=new HashMap<Integer,Integer>();
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;","sa","accolite");
			//pstmt = conn.prepareStatement("INSERT INTO dbo.employees values(?,?,?,?)");/*
			/*
			 * stmt.addBatch("IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Temp') CREATE DATABASE Temp;");
			stmt.addBatch("IF  NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'Temp2') CREATE DATABASE Temp2;");
			stmt.addBatch("USE  Temp IF OBJECT_ID('Temp.dbo.State', 'U') IS NOT NULL DROP TABLE Temp.dbo.State;");
			*/
			vip.clear();
			viprelation.clear();
			pstmt=conn.prepareStatement("delete from temp.dbo.State");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("delete from temp.dbo.District");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("delete from temp.dbo.Diststate");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("delete from temp2.dbo.Citizen");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("delete from temp.dbo.Relation");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("delete from temp.dbo.president");
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert into temp.dbo.state values(1,'Delhi'),(2,'MP'),(3,'UP')");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert into temp.dbo.District values(1,'Uttam Nagar'),(2,'Chandni Chowk'),(3,'Vasant Village'),(4,'Annupur'),(5,'Bhopal'),(6,'Agra'),(7,'Aligarh'),(8,'Allahbad')");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert  into temp.dbo.Diststate values(1,1,2),(2,1,NULL),(3,1,NULL),(4,2,NULL),(5,2,6),(6,3,NULL),(7,3,7),(8,3,NULL);");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert into temp2.dbo.Citizen values(1,'Modi',1,58),(2,'Kejari',2,40),(3,'Ram',1,20),(4,'sham',3,20),(5,'sita',5,21),(6,'gita',5,21),(7,'Amar',6,22),(8,'Akbar',7,23),(9,'Anthony',8,24);");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert into temp.dbo.Relation values(1,6),(1,1);");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("insert into temp.dbo.president values (1);");
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement("select * from temp.dbo.president");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vip.put(rs.getInt(1),1);
			}
			pstmt=conn.prepareStatement("select Head from temp.dbo.Diststate");
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				vip.put(rs.getInt(1),1);
			}
			pstmt=conn.prepareStatement("select * from temp.dbo.Relation");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				if(vip.containsKey(rs.getInt(1))){
					viprelation.put(rs.getInt(2),2);
				}
			}
			
			//insert  into temp.dbo.Diststate values(1,1,1),(2,1,2),(3,1,3),(4,2,4),(5,2,5),(6,3,6),(7,3,7),(8,3,8)
			//insert into temp2.dbo.Citizen values(1,'Modi',2,58),(2,'Kejari',2,40),(3,'Ram',1,20),(4,'sham',3,20),(5,'sita',5,21),(6,'gita',5,21),(7,'Amar',6,22),(8,'Akbar',7,23),(9,'Anthony',8,24);
			//insert into vip values(1),(2);

			
			//stmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listAllStates(){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select Name from temp.dbo.State");
			
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void listAllDistricts(){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select Name from temp.dbo.District");
			
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void displayCitizenCount(){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select count(*),temp.dbo.State.Name from temp2.dbo.Citizen join temp.dbo.Diststate on (temp2.dbo.Citizen.DistrictID=temp.dbo.Diststate.DistrictID )join temp.dbo.State on (temp.dbo.Diststate.StateID=temp.dbo.State.ID) Group by temp.dbo.State.ID,temp.dbo.State.Name");
			
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void removeDistrict(int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("delete from temp.dbo.District where temp.dbo.District.ID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("delete from temp.dbo.Diststate where temp.dbo.Diststate.DistrictID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("update temp2.dbo.Citizen set temp2.dbo.Citizen.DistrictID=NULL where temp2.dbo.Citizen.DistrictID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			pstmt.executeUpdate();
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void removeState(int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("delete from temp.dbo.State where temp.dbo.State.ID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("update temp.dbo.Diststate set temp.dbo.Diststate.StateID=NULL where temp.dbo.Diststate.StateID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			pstmt.executeUpdate();
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listAllUnderDistrict(int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select temp2.dbo.Citizen.Name from temp2.dbo.Citizen join temp.dbo.Diststate on (temp2.dbo.Citizen.DistrictID=temp.dbo.Diststate.DistrictID )join temp.dbo.State on (temp.dbo.Diststate.StateID=temp.dbo.State.ID) where temp.dbo.Diststate.DistrictID=?;");
			pstmt.setInt(1,n);
			pstmt.addBatch();
			rs=pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void listAllUnderState(int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select temp2.dbo.Citizen.Name from temp2.dbo.Citizen join temp.dbo.Diststate on (temp2.dbo.Citizen.DistrictID=temp.dbo.Diststate.DistrictID )join temp.dbo.State on (temp.dbo.Diststate.StateID=temp.dbo.State.ID) where temp.dbo.State.ID=?;");
			pstmt.setInt(1,n);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void showHead(int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select Name from temp2.dbo.Citizen where ID=(select Head from temp.dbo.Diststate where temp.dbo.Diststate.DistrictID=?);");
			pstmt.setInt(1,n);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void changeHead(int d,int n){
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			pstmt = conn.prepareStatement("select DistrictID from temp2.dbo.Citizen where ID=?");
			pstmt.setInt(1,n);
			rs=pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)!=d){
				System.out.println("not belong to district");
				return;
			}
			pstmt = conn.prepareStatement("select age from temp2.dbo.Citizen where ID=?");
			pstmt.setInt(1,n);
			rs=pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1)>60){
				System.out.println("age exceeded");
				return;
			}
			pstmt = conn.prepareStatement("update Diststate set Head=? where DistrictID=?");
			pstmt.setInt(1,n);
			pstmt.setInt(2, d);
			pstmt.executeUpdate();
			vipcompute();
			/*
			pstmt.setInt(1,);
			pstmt.setInt(4, age);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			*/
			//pstmt.executeBatch();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void techdet(){
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"+"DataBaseName=temp","sa","accolite");
			dbmd = conn.getMetaData();
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			System.out.println("-----: "+dbmd.getDriverName()); 
			ResultSet rs=dbmd.getTables("AdventureWorks2014","Person","Contact",null);
			while (rs.next()) {
				System.out.println(rs.getString(1));// + " " + rs.getInt(4) + " " + rs.getString(3) + " " + rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
