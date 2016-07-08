package hashMap;

public class HashMap<K,V> {
	public Node<K,V>[] list;
	int size=90;
	class Node<K,V>{
		K key;
		V value; 
		Node<K,V> next,prev;
		Node(K key,V value,Node<K,V> next,Node<K,V> prev){
			this.key = key;
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}
	public HashMap(){
		list = new Node[size];
	}
	
	public int getHash(K key){
		return Math.abs(key.hashCode())%size;
	}
	
	public V get(K key){
		int keyHash = getHash(key);
		if(list[keyHash]==null)
			return null;
		else{
			 Node<K,V> linked = list[keyHash];
	         while(linked!= null){
	             if(linked.key.equals(key))
	                 return linked.value;
	             linked = linked.next; //return value corresponding to key.
	         }         
	         return null;   //returns null if key is not found.
	        }
	    }
	
	public void printHash(){
		
	}
	
	public void put(K newKey,V value){
		
		if(newKey==null)
			return;
		int hash = getHash(newKey);
	     Node<K ,V > newNode = new Node<K ,V>(newKey,value,null,null);
	        if(list[hash] == null){
	         list[hash] = newNode;
	        }else{
	           Node<K,V> previous = null;
	           Node<K,V> current = list[hash];
	           
	           while(current != null){ 
	           if(current.key.equals(newKey)){           
	               if(previous==null){ 
	                     newNode.next=current.next;
	                     list[hash]=newNode;
	                     return;
	               }
	               else{
	                   newNode.next=current.next;
	                   previous.next=newNode;
	                   return;
	               }
	           }
	           previous=current;
	             current = current.next;
	         }
	         previous.next = newNode;
	        }
	        
	}
}

