import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class main {
	static LinkedHM linkedhash;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedhash=new LinkedHM();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n!=-1){
			if(n==1){
				int key=sc.nextInt();
				int value=sc.nextInt();
				linkedhash.put(key, value);
			}
			else if(n==2){
				int key=sc.nextInt();
				if(linkedhash.get(key)!=null){
					System.out.println(linkedhash.get(key).key+" "+linkedhash.get(key).value);
				}
				else{
					System.out.println("Element not there");
				}
			}
			else if(n==3){
				linkedhash.display();
			}
			n=sc.nextInt();
		}
		/*
		for(int i=0;i<n;i++){
			int key=sc.nextInt();
			int value=sc.nextInt();
			linkedhash.put(key, value);
			
		}
		*/
		linkedhash.display();
	}
}
