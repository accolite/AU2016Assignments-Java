import java.util.HashMap;

public class LinkedHM {
	Box[] linkedHashMap;
	Box head;
	Box last;
	public LinkedHM() {
		// TODO Auto-generated constructor stub
		linkedHashMap=new Box[97];
		head=null;
		last=null;
	}
	void put(int key,int value){
		Box b=new Box(key,value);
		addinsequence(b);
		addincollision(key, b);
		
	}
	Box get(int key){
		int index=getHash(key);
		Box b=linkedHashMap[index];
		if(b==null){
			return null;
		}
		while(b.key!=key&&b!=null){
			b=b.linknext;
		}
		if(b!=null){
			return b;
		}
		return null;
	}
	int getHash(int key){
		
		if(key<0){
			key=key+97;
		}
		return key%97;
	}
	void addinsequence(Box b){
		b.seqprev=null;
		b.seqnext=null;
		if(head==null){
			head=b;
			last=b;
		}
		else{
			Box trav=head;
			while(trav.seqnext!=null&&trav.key!=b.key){
				trav=trav.seqnext;
			}
			if(trav.key==b.key){
				b.seqnext=trav.seqnext;
				//trav.seqnext=b;
				b.seqprev=trav.seqprev;
				if(trav.seqprev!=null){
					trav.seqprev.seqnext=b;
				}
				if(trav.seqnext!=null){
					trav.seqnext.seqprev=b;
				}
				if(trav.seqprev==null){
					head=b;
				}
			}
			else{
				b.seqnext=trav.seqnext;
				trav.seqnext=b;
				b.seqprev=trav;
			}
			
		}
	}
	void addincollision(int key,Box b){
		int index=getHash(key);
		Box trav=linkedHashMap[index];
		b.linknext=null;
		b.linkprev=null;
		if(trav==null){
			linkedHashMap[index]=b;
		}
		else{
			while(trav.linknext!=null&&trav.key!=key){
				trav=trav.linknext;
			}
			if(trav.key==key){
				b.linknext=trav.linknext;
				//trav.seqnext=b;
				b.linkprev=trav.linkprev;
				if(trav.linkprev!=null){
					trav.linkprev.linknext=b;
				}
				if(trav.linknext!=null){
					trav.linknext.linkprev=b;
				}
				if(trav.linkprev==null){
					linkedHashMap[index]=b;
				}
			}
			else{
				b.linknext=trav.linknext;
				trav.linknext=b;
				b.linkprev=trav;
			}
		}
	}
	void displayInsertionOrder(Box head){
		if(head==null){
			System.out.println("Empty");
			return;
		}
		Box trav=head;
		while(trav!=null){
			System.out.println("("+trav.key+","+trav.value+")");
			trav=trav.seqnext;
		}
	}
	void display(){
		displayInsertionOrder(head);
	}
	
	}

