package com.accolite.au.jdbc.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

import com.accolite.au.jdbc.Citizen;
import com.accolite.au.jdbc.District;
import com.accolite.au.jdbc.State;

public class Driver {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Citizen citizen = new Citizen();
		District district = new District();
		State state = new State();
		int option = 0;
		while(true){
			System.out.println("\n\n"
					+ "Please select one \n"
					+ "1. List all the states\n"
					+ "2. List all the districts\n"
					+ "3. Display the citizen count for all the states\n"
					+ "4. Remove a district\n"
					+ "5. Remove a state\n"
					+ "6. List of Citizens under State\n"
					+ "7. List of Citizens under District\n"
					+ "8. Show head of a district\n"
					+ "9. Remove head of a district\n"
					+ "10. List technical details\n"
					+ "11. Change head of a district\n"
					+ "12. Reset DB(Not implemented)" 	// Not implemented
					+ "0. Exit");
			try{
				option = scanner.nextInt();
			}
			catch(Exception e){
				option = 0;
			}
			switch (option) {
				case 0:
					System.exit(0);
					break;
				case 1:
					System.out.println("\n======================");
					state.displayAll();
					System.out.println("\n======================");
					break;
				case 2:
					System.out.println("\n======================");
					district.displayAll();
					System.out.println("\n======================");
					break;
				case 3:
					System.out.println("\n======================");
					citizen.displayCitizenCountByState();
					System.out.println("\n======================");
					break;
				case 4:
					System.out.println("\n======================");
					System.out.print(" Enter the district name : ");
					String dist_name = scanner.next();
					if(district.removeDistrict(dist_name))
						System.out.println("Removed");
					else
						System.out.println("Can't be done");
					System.out.println("\n======================");
					break;
				case 5:
					System.out.println("\n======================");
					System.out.print(" Enter the State name : ");
					String stat_name = scanner.next();
					if(state.removeState(stat_name))
						System.out.println("Removed");
					else
						System.out.println("Can't be done");
					System.out.println("\n======================");
					break;
				case 6:
					System.out.println("\n======================");
					System.out.print(" Enter the state name : ");
					String state_name = scanner.next();
					citizen.displayCitizenByState(state_name);
					System.out.println("\n======================");
					break;
				case 7:
					System.out.println("\n======================");
					System.out.print(" Enter the district name : ");
					String district_name = scanner.next();
					citizen.displayCitizenByDistrict(district_name);
					System.out.println("\n======================");
					break;
				case 8:
					System.out.println("\n======================");
					System.out.print(" Enter the district name : ");
					String dis_name = scanner.next();
					String head = district.getHead(dis_name);
					if(head != null)
						System.out.println("Head of district "+dis_name+ " is "+head);
					else
						System.out.println("Head of district "+dis_name+" does not exist");
					System.out.println("\n======================");
					break;
				case 9:
					System.out.println("\n======================");
					System.out.print(" Enter the district name : ");
					String dis_name1 = scanner.next();
					if(district.removeHead(dis_name1))
						System.out.println("Head of district "+dis_name1+ " removed");
					else
						System.out.println("Can't be done");
					System.out.println("\n======================");
					break;
				case 10:
					System.out.println("\n======================");
					citizen.displayTechnicalDetails();
					System.out.println("\n======================");
					break;
				case 11:
					System.out.println("\n======================");
					System.out.print(" Enter the district name : ");
					String d = scanner.next();
					System.out.print(" Enter the person name : ");
					String h = scanner.next();
					if(district.changeHead(d,h))
						System.out.println("Head of district "+d+ " Changed");
					else
						System.out.println("Can't be done");
					System.out.println("\n======================");
					break;
				default:
					System.out.println("\n\n\t\tPlease input correct option \n\n");
					break;
				}
		}
		
	}
}
