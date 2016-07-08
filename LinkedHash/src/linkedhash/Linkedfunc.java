package linkedhash;
import java.util.Scanner;
public class Linkedfunc {
	public static void main(String[] args)
	{
		LinkedMain linkedhash=new LinkedMain();
		Scanner in =new Scanner(System.in);
		int choice;
		int key;
		int value;
		while(true)
		{
		System.out.println("Enter your choice 1) Put 2)Get 3)Display 4) Exit");
		choice=in.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Dispalying value for key");
			 key=in.nextInt();
			 System.out.println("Dispalying value for value");
			 value=in.nextInt();
			 linkedhash.put(key,value);
			 break;
		case 2:
			System.out.println("Dispalying value for key:");
			key=in.nextInt();
			System.out.println("Dispalying value for key"+" "+ linkedhash.get(key));
			break;
		case 3:
			linkedhash.display();
			break;
		case 4:
			break;
		}
		
	
		}	
	}
}
