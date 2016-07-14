package com.accolite.au.jdbc;

import java.util.Scanner;

public class Test {

	public static void main(String args[])
	{
		int choice;
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.print("1.List all states\n"
					+ "2.List all districts\n"
					+ "3.Display the citizen count for all states\n"
					+ "4.Remove a district\n"
					+ "5.Remove a state\n"
					+ "6.List of citizens under state\n"
					+ "7.List of citizens under district\n"
					+ "8.Show Head of a district\n"
					+"9.Change Head of a district\n"
					+"10.List Technical Details\n"
					+ "11.Exit");
			choice = in.nextInt();
			switch(choice)
			{
			case 1://List all States
					System.out.println("StateID\tStateName\tPresidentID");
					ListStates ls = new ListStates();
					ls.displayStates();
					break;
			case 2:
					System.out.println("DistrictID\tDistrictName\tHeadID\tStateID\tStatus");
					ListDistricts ld = new ListDistricts();
					ld.displayDistricts();
					break;
			case 3:
					System.out.println("State Name\tNumber of Citizens");
					CountCitizens cnt = new CountCitizens();
					cnt.getCitizenCount();
					break;
			case 4:
					break;
			case 5:
					break;
			case 6:
					System.out.println("Enter a State");
					Scanner inp = new Scanner(System.in);
					String sname ;
					sname = inp.next();
					CitizenUnderSate cs = new CitizenUnderSate();
					cs.getCitizenState(sname);
					break;
			case 7:
					System.out.println("Enter a District");
					Scanner inp1 = new Scanner(System.in);
					String sname1 ;
					sname1 = inp1.next();
					CitizenUnderDistrict cd = new CitizenUnderDistrict();
					cd.getCitizenDistrict(sname1);
					break;
			case 8:
					System.out.println("Enter a District");
					Scanner inp2 = new Scanner(System.in);
					String sname2 ;
					sname2 = inp2.next();
					DistrictHead dh = new DistrictHead();
					dh.getDistrictHead(sname2);
					break;
			case 9:
					System.out.println("Enter District name and Citizen name");
					Scanner inp3 = new Scanner(System.in);
					String district,citizen;
					district = inp3.next();
					citizen = inp3.next();
					ChangeHead ch = new ChangeHead();
					ch.ChangeDistrictHead(district, citizen);
					break;
			case 10:
					System.out.println("The Technical Details are");
					Metadata md = new Metadata();
					md.getTechnicalDetails();
					break;
			default:
					break;
			}
			if(choice == 11)
				break;
			}
		}

	
		
	}

