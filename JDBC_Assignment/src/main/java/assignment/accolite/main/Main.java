package assignment.accolite.main;

import assignment.accolite.DAO.CitizenDAO;
import assignment.accolite.DAO.DistrictDAO;
import assignment.accolite.DAO.StateDAO;
import assignment.accolite.DAO.VipDAO;
import assignment.accolite.QuerySolutions;
import assignment.accolite.database.Database;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Mitul Kapoor on 7/14/2016.
 */
public class Main {

    public static void menu(){
        System.out.println("1. List all the states \n"
                + "2. List all the districts \n"
                + "3. Display the citizen count for all the states \n"
                + "4. Remove a district \n"
                + "5. Remove a state \n"
                + "6. List of citizens under state \n"
                + "7. List of citizens under district \n"
                + "8. Show head of a district \n"
                + "9. Change Head of a district \n"
                + "10. List technical details \n"
                + "11. Create or restore data and tables");
    }

    public static void populateData() throws SQLException {
        CitizenDAO citizenDAO = new CitizenDAO();
        DistrictDAO districtDAO = new DistrictDAO();
        StateDAO stateDAO = new StateDAO();
        VipDAO vipDAO = new VipDAO();
        citizenDAO.populateCitizenData();
        districtDAO.populateDistrictData();
        stateDAO.populateStateData();
        //vipDAO.populateVipData();
    }


    public static void main(String []args){
        try {
            Database database = new Database();
            QuerySolutions querySolutions = new QuerySolutions();
            populateData();
            int ch = 1;
            Scanner input = new Scanner(System.in);
            while(ch ==1 ){
                menu();
                int choice = input.nextInt();
                switch(choice){
                    case 1: querySolutions.Ques1();break;
                    case 2:querySolutions.Ques2();break;
                    case 3:querySolutions.Ques3();break;
                    case 4:querySolutions.Ques4();break;
                    case 5:querySolutions.Ques5();break;
                    case 6:querySolutions.Ques6();break;
                    case 7:querySolutions.Ques7();break;
                    case 8:querySolutions.Ques8();break;
                    case 9:querySolutions.Ques9();break;
                    case 10:querySolutions.Ques10();break;
                    default : System.exit(0);
                }
                System.out.println("Continue..");
                ch = input.nextInt();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
