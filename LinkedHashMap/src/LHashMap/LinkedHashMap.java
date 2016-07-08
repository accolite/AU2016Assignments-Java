package LHashMap;

import java.util.ArrayList;
import java.util.Scanner;

public class LinkedHashMap {
	Node common_prev;
	Node common_next;
	Node head;
	int maxsize = 10;
	ArrayList<Node> array;

	public LinkedHashMap() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.common_prev = null;
		this.array = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			this.array.add(i, null);
		}
	}

	int getHashValue(int key) {
		return key % 10;
	}

	void put(int key, int value) {
		
		int hv = getHashValue(key);
		if(hv<0)hv=-hv;
		Node node = new Node(key, value);
		if (common_prev == null) {
			head = node;
		}
		if (this.array.get(hv) == null) {
			common_prev = node;
			this.array.add(hv, node);
		} else {

			node.prev = common_prev;
			common_prev.next = node;
			common_prev = node;
			Node temp;
			temp = array.get(hv);
			while (temp.hnext != null&&temp.key!=node.key) {
				temp = temp.hnext;
			}
			if(temp.key==node.key)
			{
				temp.value=node.value;
			}
			else
			temp.hnext = node;

		}
	}

	int get(int key) {
		
		int hv = getHashValue(key);
		if(hv<0)hv=-hv;
		Node temp;
		if( this.array.get(hv)!=null){
		 temp= this.array.get(hv);
		// System.out.println(temp.key);
		while (temp.key != key && temp != null) {
			temp = temp.hnext;
		}

		if (temp == null) {
			return -1;
		} else
			return temp.value;}
		else
		{
			return -1111;
		}
	}

	void iterate() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public static void main(String args[]) {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int key = 0, value = 0;
		System.out.println("enter choice 1. put 2. get 3. iterate 4.quit");
		choice = sc.nextInt();

		while (choice != 4) {
			switch (choice) {
			case 1:
				System.out.println("enter the key value pairs");
				key = sc.nextInt();
				value = sc.nextInt();
				linkedHashMap.put(key, value);
				break;
			case 2:
				System.out.println("enter the key ");
				key = sc.nextInt();
				value = linkedHashMap.get(key);
				if(value==-1111)System.out.println("no such key");
				else{System.out.println(key);

				System.out.print(" "+value);}
				break;
			case 3:
				System.out.println("Iteration");
				linkedHashMap.iterate();
				break;
			default:
			}
			System.out.println("enter choice 1. put 2. get 3. iterate 4.quit");
			choice = sc.nextInt();

		}

	}

}
