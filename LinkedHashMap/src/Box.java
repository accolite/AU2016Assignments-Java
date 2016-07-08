
public class Box {
	Box seqprev;
	int key;
	int value;
	Box seqnext;
	Box linkprev;
	Box linknext;
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
	
	Box(){
		
	}
	Box(int key,int value){
		this.key=key;
		this.value=value;
	}
	Box(Box b,int key,int value){
		seqprev=b;
		this.key=key;
		this.value=value;
	}
	
	
}
