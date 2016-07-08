package com.accolite.linkedHashMap;

import java.util.HashMap;

public class NodeArrayList {
	
	private String key;
	Object hashMapEntry;
	
	public NodeArrayList(String key, Object hashMapNode) {
		// TODO Auto-generated constructor stub
		this.key=key;
		hashMapEntry=hashMapNode;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getHashMapEntry() {
		return hashMapEntry;
	}
	public void setHashMapEntry(Object hashMapEntry) {
		this.hashMapEntry = hashMapEntry;
	}
	
	
	

}
