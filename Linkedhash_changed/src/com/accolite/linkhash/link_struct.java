package com.accolite.linkhash;

public class link_struct {
	
		int key;
		public int getKey() {
			return key;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		int value;
		link_struct next;
		
		link_struct(int k,int v)
		{
			key=k;
			value=v;
			next=null;
			
		}
		


}
