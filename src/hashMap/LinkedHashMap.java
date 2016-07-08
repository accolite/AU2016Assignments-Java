package hashMap;
import java.util.*;
public class LinkedHashMap {
	public static void main(String args[]){
		HashMap<Object,Object> hash = new HashMap<>();
		ArrayList keys = new ArrayList();
		//HashMap.Node<Object, Object> = new HashMap.Node =null;
		//hash.put(4, 2);
		//hash.put(2, 12);
		//hash.put(2, 45);
		//hash.put(4, 34);
		//HashMap.Node<Integer, Integer> head;
		int n;
		int continu;
		//boolean flag=false;
		int key,value;
		do{
			n=0;
		System.out.println("Enter the option:\n 1: Add a key,value\n2: Get a value from key\n3:"
				+ "Get Iteration\n");
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		switch(n){
		case 1:
			System.out.println("Enter key and value:\n");
			key = input.nextInt();
			value = input.nextInt();
			hash.put(key, value);
			Object s = key;
			int idx = 0;
			if(!keys.contains(key))
			keys.add(key);
			break;
		case 2:
			System.out.println("Enter key:\n");
			key = input.nextInt();
			System.out.println(hash.get(key));
			break;
		case 3:
			for(int i=0;i<keys.size();i++){
				System.out.println(keys.get(i)+" "+hash.get(keys.get(i)));
			}
		}
		System.out.println("If u want to continue: 1: Yes 2: No");
		continu = input.nextInt();
		if(continu==2)
			break;
		}while(true);
		return;
	}
}
