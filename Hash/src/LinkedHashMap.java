import java.util.ArrayList;
import java.util.Scanner;
public class LinkedHashMap {
	
	     private static final Node NULL = null;
		 private Node head;
		 private Node ord;
	     private int size;
	     private ArrayList<Node> list;
	     
         public LinkedHashMap() {
 			super();
 			this.head = NULL;
 			this.size = 0;
 			this.list = new ArrayList<Node>();
            for(int i=0;i<1000;i++){
            	list.add(NULL);
            }    
 		}
		private class Node{
        	 
		        	 private Object data;
		        	 private Object key;
		        	 private Node next;
		        	 private Node prev;
		        	 private Node ord;
		        	
					public Node(Object data2, Object key2, Node null1, Node null2, Node null3) {
						   this.data=data2;
						   this.key=data2;
						   this.next=NULL;
						   this.prev=NULL;
						   this.ord=NULL;
					}
					public Object getData() {
						return data;
					}
					public void setData(int data) {
						this.data = data;
					}
					public Node getNext() {
						return next;
					}
					public void setNext(Node next) {
						this.next = next;
					}
					public Node getPrev() {
						return prev;
					}
					public void setPrev(Node prev) {
						this.prev = prev;
					}
					public Node getOrd() {
						return ord;
					}
					public void setOrd(Node ord) {
						this.ord = ord;
					}
					public Object getKey() {
						return key;
					}
					public void setKey(Object key) {
						this.key = key;
					}
         }
         
         
      public void putdata(Object key,Object data){
    	     int pos=(key.hashCode())%1000;
              if(list.get(pos)==NULL){
            	   list.set(pos,new Node(data,key,NULL,NULL,NULL));
            	   if(head==NULL)
            	   head=list.get(pos);    
              }
              Node temp=list.get(pos);
              while(temp.getNext()!=NULL){
            	  temp=temp.getNext();
              }
    	      temp.setNext(new Node(data,key,NULL,NULL,NULL));
    	      Node temp1=temp.getNext();
    	      temp1.setPrev(temp);
    	      if(head.getNext()==NULL){
    	    	  ord=head;
    	      }
    	      else{
    	    	  ord.setOrd(temp1); 
    	    	  ord=temp1;
    	      }
    	     
    	      size++;
       }
    
     public Object getata(Object key){
    	 int pos=key.hashCode();
    	 Node temp=list.get(pos);
    	 while(temp.getKey()!=key){
    		 temp=temp.getNext();
    	 }
    	 return temp.getData();
     }
     
     public void print(){
    	 if(head==NULL){
    		 System.out.print("NO input");
    	 }
    	 else{
    		Node temp=head; 
    		System.out.println(size);
    		for(int i=0;i<size;i++){
    			System.out.println(temp.getData());
    			temp=temp.getOrd();
    		} 
    		 
    	 }
     }
     
     
 
    public static void main(String args[]){
    	LinkedHashMap lhm= new LinkedHashMap();
    	lhm.putdata(12,"ravi");
    	lhm.putdata(1,"rvi");
    	lhm.putdata(132,"rai");
    	lhm.putdata(122,"ri");
    	lhm.putdata(112,"vi");
    	lhm.print();
    	System.out.println("Enter choice ");
    	Scanner input= new Scanner(System.in);
		int c=input.nextInt();
		switch(c){
		case 1:
			System.out.println("Enter key and value: ");
			obj.put(a, b);
			break;
		case 2:
			System.out.println("Enter key : ");
			obj.getdata(key);
			break;
		case 3:
		    obj.print();
			break;
		default:
			System.out.println("Incorrect");
		}
    	
     }
}
/*
 
 */
 */