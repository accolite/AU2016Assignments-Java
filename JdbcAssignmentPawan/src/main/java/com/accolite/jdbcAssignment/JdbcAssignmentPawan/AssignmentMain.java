package com.accolite.jdbcAssignment.JdbcAssignmentPawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class AssignmentMain {

	public static void main(String[] args) {
		CreateDbAndTables ct = new CreateDbAndTables();
		InsertIntoTablesAuto insertIntoAuto = new InsertIntoTablesAuto();
		InsertIntoTablesManual insertIntoManual = new InsertIntoTablesManual();
		System.out.println("Do you want to Create new DB and Tables y/n ");
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		if (inp.equals("y"))
			ct.create();
		else {
			
		}
			
		System.out.println("Do you want to Insert Data in tables y/n ");
		String input1 = sc.next();
		if (input1.equals("y")) {
			System.out.println("Press 1) --> Automatic random insert\nPress 2) --> Manual insert");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				insertIntoAuto.insert();
				break;
			case 2:
				insertIntoManual.insert();
				break;
			}
		}
			
		else {				
		}
		
		// work on queries
		
		
		Scanner input = new Scanner(System.in);
		  System.out.println("     1. List all the states 2. List all the districts 3. Display the citizen count for all the states");
		  System.out.println("     4. Remove a district  5. Remove a state 6. List of citizens under state");
		  System.out.println("     7. List of citizens under district 8. Show head of a district 9. Change Head of a district");
		  System.out.println("     10. List technical details 11. Create or restore data and tables");
		  System.out.println();
		  while(true) {
		   System.out.println("choose one option or choose 0 to exit");
		   int a = input.nextInt();
		   if(a == 0) {
		    break;
		   }
		   switch(a) {
		    case 1:
		    queries.List_all_the_states();
		     break;
		    case 2:
		    	queries.List_all_the_districts();
		     break;
		    case 3:
		    	queries.Display_the_citizen_count_for_all_the_states();
		     break;
		    case 4:
		    	queries.Remove_a_district();
		     break;
		    case 5:
		    	queries.Remove_a_state();
		     break;
		    case 6:
		    	queries.List_of_citizens_under_state();
		     break;
		    case 7:
		    	queries.List_of_citizens_under_district();
		     break;
		    case 8:
		    	queries.Show_head_of_a_district();
		     break;
		    case 9:
		    	queries.Change_Head_of_a_district();
		     break;
		    case 10:
		    	queries.List_technical_details();
		     break;
		    case 11:
		    	queries.Create_or_restore_data_and_tables();
		     break;
		    default:
		     System.out.println("chosse valid option");
		     break;
		     
		   }
		  }
	}
}
