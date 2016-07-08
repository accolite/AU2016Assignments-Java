package com.accolite.linkedHashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkedHashMap {
	
	HashMap<String, Integer> myHashMap;
	ArrayList<NodeArrayList> arrayListToStoreNodes;
	
	public LinkedHashMap() {
		// TODO Auto-generated constructor stub
		myHashMap = new HashMap<>();
		arrayListToStoreNodes = new ArrayList<>();
	}
	
	
	public HashMap<String, Integer> getMyHashMap() {
		return myHashMap;
	}
	public void setMyHashMap(HashMap<String, Integer> myHashMap) {
		this.myHashMap = myHashMap;
	}
	public ArrayList<NodeArrayList> getArrayListToStoreNodes() {
		return arrayListToStoreNodes;
	}
	public void setArrayListToStoreNodes(ArrayList<NodeArrayList> arrayListToStoreNodes) {
		this.arrayListToStoreNodes = arrayListToStoreNodes;
	}
	
	public String get(String key)
	{
		return myHashMap.get(key).toString();
	}
	
	public void searchIfAlreadyExists(String key){
        for(int i=0;i<arrayListToStoreNodes.size();i++){
            if(arrayListToStoreNodes.get(i).getKey() == key){
            	arrayListToStoreNodes.remove(i);
            }
        }
    }
	
	public void put(String key, int value)
	{
		
		myHashMap.put(key, value);
		Object node=myHashMap.get(key);
		NodeArrayList nodeInArray =new NodeArrayList(key,node);
		searchIfAlreadyExists(key);
		arrayListToStoreNodes.add(nodeInArray);
	}
	
	

}
