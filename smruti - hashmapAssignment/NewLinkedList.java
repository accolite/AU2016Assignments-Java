package hashmapAssignment;

import java.util.Iterator;
import java.util.LinkedList;

public class NewLinkedList {

	LinkedList<Entry> indices[] = new LinkedList[50];
	Entry temp = new Entry();
	
    public int hashCode(int key) {
    	int sum = 0;
    	if(key <= 50)
    		return key;
    	else {
    		while((key / 10) != 0) {
    			sum += (key % 10);
    			key = key / 10;
    		}
    		sum += key;
    		return sum;
    	}
    		
    }
	
	public Entry add(int key, int value) {
		
		Entry newEntry = new Entry();
		//Entry pointer = indices.get(index);
		LinkedList<Entry> list = new LinkedList<Entry>();
		newEntry.key = key;
		newEntry.value = value;
		int index = hashCode(key);
		if(indices[index] == null) {
			indices[index] = list;/*
			newEntry.prevPointer = null;
			newEntry.nextPointer = null;*/
			list.add(newEntry);
		}
		else {
			temp.orderPointer = newEntry;
			temp = newEntry;/*
			newEntry.nextPointer = null;
			newEntry.prevPointer = null;*/
			indices[index].add(newEntry);
		}
		return newEntry;
	}
	
	public int get(int key) {
		int index = hashCode(key);
		Entry entry = new Entry();
		LinkedList<Entry> next = indices[index];
		Iterator<Entry> itr = next.iterator();
		if(next == null)
			return -1;
		else {
			while(itr.hasNext()) {
				entry = itr.next();
				if(entry.key == key)
					return entry.value;
			}
		}
		return -1;
	}
	
	public void print(Entry order) {
		Entry nextEntry = order;
		while(nextEntry.orderPointer != null) {
			System.out.println(nextEntry.value);
			nextEntry = nextEntry.orderPointer;
		}
	}
}
