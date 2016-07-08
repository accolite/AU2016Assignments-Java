package com.accolite.hashmap;

import java.util.LinkedList;

public class Hashmap<K,V> {
		   
		   class Node<K, V> {
		      private  K key;
		      private V value;
		      
		      public Node(K key, V value) {
		         this.key = key; 
		         this.value = value;
		      }
		      
		      public K getKey() {
		         return this.key;
		      }
		      
		      public V getValue() {
		         return this.value;
		      }
		      
		      public void setValue(V value) {
		         this.value = value;
		      }
		      
		
		   }
		   
		   private static int MIN_SIZE = 32;
		   private int size;
		   private LinkedList<Node<K, V>>[] elements;
		   
		   public Hashmap() {
		      this(MIN_SIZE);
		   }
		   
		   public Hashmap(int size) {
		      this.size = size;
		      this.elements = (LinkedList<Node<K, V>>[])new LinkedList[size];
		   }
		   
		   
		   private int Hashcode(K key) {
		     return key.hashCode()%MIN_SIZE;
		   }
		   
		   public V get(K key) {
		      int index = Hashcode(key) % size;
		      if ( elements[index] == null ) {
		         return null;
		      }
		      
		      for ( Node<K, V> i : elements[index] ) {
		         if ( i.getKey().equals(key) ) {
		            return i.getValue();
		         }
		      }
		      return null;
		   }
		   
		   public void put(K key, V value) {
		      int index = Hashcode(key) % size;
		      if ( elements[index] == null ) {
		         elements[index] = new LinkedList<>();
		      }
		      
		      for ( Node<K, V> i : elements[index] ) {
		         if ( i.getKey().equals(key) ) {
		            elements[index].remove(i);
		            break;
		         }
		      }
		      
		      elements[index].add( new Node<>(key, value) );
		   }
		   
	}
	

