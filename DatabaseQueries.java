package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.au.assignment.util.Constants;

public class DatabaseQueries {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		
		// TODO Auto-generated method stub
		System.out.println("Enter the number for query to execute:");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
	
		switch (num)
		{
		case 1:
			ListAllStates states = new ListAllStates();
			states.list();
			break;
		case 2:
			ListAllDistricts district = new ListAllDistricts();
			district.list();
			break;
		case 3:
			DisplayCitizenCount dc = new DisplayCitizenCount();
			dc.list();
			break;
		case 4:
			RemoveDistrict rd = new RemoveDistrict();
			rd.RemovingADistrict();
			break;
		case 5:
			RemoveState rs = new RemoveState();
			rs.RemovingAState();
			break;
		case 6:
			ListCitizensUnderState cs = new ListCitizensUnderState();
			cs.list();
			break;
		case 7:
			ListCitizensUnderDistrict cd = new ListCitizensUnderDistrict();
			cd.list();
			break;
		case 8:
			ShowHeadOfDistrict sh = new ShowHeadOfDistrict();
			sh.list();
			break;
		case 9:
			ChangeHeadOfDistrict cod = new ChangeHeadOfDistrict();
			cod.change();
			break;
		case 10:
			ListTechnicalData list = new ListTechnicalData();
			list.listTechnicalData();
			break;
		case 11:
			CreateTables table = new CreateTables();
			table.create();
			InsertValuesinTables insert = new InsertValuesinTables();
			insert.insert("citizen");
			insert.insert("district");
			insert.insert("state");
			insert.insert("president");
			break;
			
		default:
			System.out.println("Enter number in range 1:11");
			break;
		}
	}
	
}
