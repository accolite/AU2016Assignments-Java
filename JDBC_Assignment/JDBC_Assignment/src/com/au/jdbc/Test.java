package com.au.jdbc;

import java.util.Scanner;

import com.au.util.Constants;





public class Test {
	
	public static void main(String arg[]){
		int choice;
		String aString;
		Scanner input=new Scanner(System.in);
		while(true){
			System.out.println("\nSelect: \n1. List all the states\n"
										+ "2. List all the districts\n"+
										"3. Display the citizen count for all the states\n"+
										"4. Remove a district\n"+
										"5. Remove a state\n"+
										"6. List of citizens under state\n"+
										"7. List of citizens under district\n"+
										"8. Show head of a district\n"+
										"9. Change Head of a district\n"+
										"10. List technical details\n"+
										"11. Create or restore data and tables\n"+
										"12.Exit");
		
		
			choice=input.nextInt();
			
			switch (choice) {
			case 1:
				ListStates listStates=new ListStates();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("List all States");
					listStates.retirve();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 2:
				ListDistrict listDistrict=new ListDistrict();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("List all District");
					listDistrict.retirve();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				CitizenCount citizenCount=new CitizenCount();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("Display the citizen count for all the states");
					citizenCount.count();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				System.out.println("Type District");
				aString=input.next();
				RemoveDistrict removeDistrict=new RemoveDistrict();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					removeDistrict.Remove(aString);
					System.out.println("Completed");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 5:
				System.out.println("Type State");
				aString=input.next();
				RemoveState removeState=new RemoveState();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					removeState.Remove(aString);
					System.out.println("Completed");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 6:
				CitizenUnderStates citizenUnderStates=new CitizenUnderStates();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("List of citizens under state\n");
					citizenUnderStates.count();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 7:
				
				CitizenUnderDistrict citizenUnderDistrict=new CitizenUnderDistrict();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("List of citizens under district\n");
					citizenUnderDistrict.count();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 8:
				HeadDistrict headDistrict=new HeadDistrict();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("List of District Head\n");
					headDistrict.head();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 9:
				ChangeHead changeHead=new ChangeHead();
				System.out.println("Type Citizen name");
				aString=input.next();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					changeHead.change(aString);
					System.out.println("Completed");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 10:
				
				TechnicalDetail technicalDetail=new TechnicalDetail();
				try {
					//Class.forName(Constants.SQL_SERVER_JDBC_DRIVER);
					
					System.out.println("Technical Information\n");
					technicalDetail.technicalInfo();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 11:
				
				break;
				
			
			default:
				break;
			}
			if(choice==12)
				break;
		}
		
		
		
	}
	
}
