package com.accolite.customlinkedhashmap;

public class NodeClass{
	public int key;
	public int value;
	public NodeClass prev,next;
 
    /* default Constructor */
    public NodeClass()
    {
    	key = 0;
    	value = 0;
        next = null;
        prev = null;
       
    }
    /* parameterized Constructor */
    public NodeClass(int key,int value, NodeClass prev, NodeClass next)
    {
    	this.key = key;
        this.value = value;
        this.prev=prev;
        this.next=next;
    }
   
    public void setPrev(NodeClass prev)
    {
        this.prev = prev;
    }    
    
    public void setNext(NodeClass next)
    {
        this.next = next;
    }
   
    public NodeClass getPrev()
    {
        return prev;
    }
    
    public NodeClass getNext()
    {
        return next;
    }
    
    public void setData(int value)
    {
        this.value = value;
    }
  
    public int getData()
    {
        return value;
    }
}
