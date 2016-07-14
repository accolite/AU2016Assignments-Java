package com.accolite.jdbcAssignment;

import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDataBaseAndTable database = new CreateDataBaseAndTable();
		database.createDB();
		database.insertDefaultData();
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
					database.List_all_the_states();
					break;
				case 2:
					database.List_all_the_districts();
					break;
				case 3:
					database.Display_the_citizen_count_for_all_the_states();
					break;
				case 4:
					int id = input.nextInt();
					database.Remove_a_district(id);
					break;
				case 5:
					int id1 = input.nextInt();
					database.Remove_a_state(id1);
					break;
				case 6:
					database.List_of_citizens_under_state();
					break;
				case 7:
					database.List_of_citizens_under_district();
					break;
				case 8:
					int id99 = input.nextInt();
					database.Show_head_of_a_district(id99);
					break;
				case 9:
					database.Change_Head_of_a_district();
					break;
				case 10:
					database.List_technical_details();
					break;
				case 11:
					database.Create_or_restore_data_and_tables();
					break;
				default:
					System.out.println("chosse valid option");
					break;
					
			}
		

	}
	}
}
