import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkedHashMap {
	
	
	ArrayList<Node> head;
	Object xx = 1;
	LinkedHashMap() {
		head = new ArrayList<Node>(10000);
		for(int i=0;i<=10000;i++) {
			head.add(i,null);
		}
		
	}
	
	Node last;
	private class Node {
		Object data;
		Node next;
		public Node(Object data, Node next) {
			
			this.data = data;
			this.next = next;
			
		}	
	}
	Object x;
	Node InsertedList = new Node(x, null);
	public Node get(Object key) {
		int Key = key.hashCode()%10000;
		if(Key < 0){
			Key += 10000;
		}
		return head.get(Key);
	}
	public void put(Object key, Object Value) {
		
		Node newnode;
		int Key = key.hashCode()%10000;
		if(Key < 0){
			Key += 10000;
		}
		
		if(head.get(Key) == null ) {
			newnode = new Node(Value, null);
			head.add(Key, newnode);
		}
			
		else {
			if(head.get(Key).data == null)
				head.add(Key, new Node(Value, null));
			else
				head.get(Key).data=Value;
		}
	}
	
	public void PrintElements() {
		
		for(int i=0;i<10000;i++){
			if(head.get(i)!=null){
				System.out.println(head.get(i).data);
			}
		}
		System.out.println("continue..");
		
	}
	
	public static void main(String []args) throws IOException {
		LinkedHashMap lhm = new LinkedHashMap();
		Scanner input = new Scanner(System.in);
		int choice;
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		Object key,value;
		
		while(true) {
		System.out.println("Press 1 for adding  2 for iter 3 to get key value pair 4 to exit");
		choice = input.nextInt();
		if (choice == 4)
			break;
		switch(choice) {
			case 1: 
					int ch=1;
					do{
						System.out.println("Enter Key");
						key = bf.readLine();
						System.out.println("Enter value");
						value = bf.readLine();
						lhm.put(key, value);
						System.out.println("Wanna add more? press 1 else 0");
						ch = input.nextInt();
					}while(ch==1);
					break;
			case 2: System.out.println("Elements are:-");
					lhm.PrintElements();
					break;
			case 3: System.out.println("Enter Key");
					key = bf.readLine();
					System.out.println(lhm.get(key).data);
					break;
			default: System.out.println("Invalid Selection");
		}
	 }	
	}
}
