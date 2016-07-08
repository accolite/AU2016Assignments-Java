package com.accolite.linkedHashMap;

public class Node {
	public int data;
	protected int key;
    protected Node next, prev;
 
    /* Constructor */
    public Node()
    {
    	key = 0;
        next = null;
        prev = null;
        data = 0;
    }
    /* Constructor */
    public Node(int d,int k, Node n, Node p)
    {
    	key = k;
        data = d;
        next = n;
        prev = p;
    }
    /* Function to set link to next node */
    public void setLinkNext(Node n)
    {
        next = n;
    }
    /* Function to set link to previous node */
    public void setLinkPrev(Node p)
    {
        prev = p;
    }    
    /* Funtion to get link to next node */
    public Node getLinkNext()
    {
        return next;
    }
    /* Function to get link to previous node */
    public Node getLinkPrev()
    {
        return prev;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }
}
