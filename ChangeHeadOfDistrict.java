package org.au.assignment.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ChangeHeadOfDistrict 
{
	static Connection conn = null;
	static Statement stmt = null;
	
	void change() throws SQLException
	{
		String sql, sql2;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("enter the district ID: ");
    int val = sc.nextInt();
    
    System.out.println("enter the citizen id of new head: ");
    int val2 = sc.nextInt();
    int age1 = 0;
    sql2 = " Select age from Country_Citizens.dbo.Citizen where Country_Citizens.dbo.Citizen.cid= "+ val2;
    ResultSet rs = stmt.executeQuery(sql2);
    while (rs.next())
    {
      age1 = rs.getInt("age");
    }
    
    if (age1 <= 60)
    {
     
     sql = " update COUNTRY.dbo.district set Head_id = "+val2+" where districtID="+ val;
     stmt.executeQuery(sql);
     
     String sql3;
     sql3 = "update COUNTRY.dbo.citizen set type = 'VIP' where cid="+ val2;
     stmt.executeQuery(sql3);
     System.out.println("updated successfully");
     // STEP 6: Clean-up environment
     rs.close();
     stmt.close();
     conn.close();
    }       
    else 
    {
     System.out.println("sorry! His age is greater than 60 ");
    }
     
    
   }
   

}
