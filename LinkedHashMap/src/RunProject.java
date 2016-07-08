import java.util.Scanner;

public class RunProject {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		
		HashMap hashMap = new HashMap();
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		while(true){
			
			System.out.println("enter 1 for add and 2 for get");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					int no = sc.nextInt();
					int key = sc.nextInt();
					hashMap.add(no,key);
					break;
					
				case 2:
					int key1 = sc.nextInt();
					System.out.println(hashMap.getNumber(key1));
					break;
			}
			
		}
		
}

}