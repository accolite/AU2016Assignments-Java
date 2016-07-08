
public class Node {
	private int key;
	private int value;
	private Node next;
	
	/** The previous. */
	private Node previous;
	
	public Node(int key, int value, Node next, Node previous) {
		this.key = key;
		this.value = value;
		this.next = next;
		this.previous = previous;
	}
	
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
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
}
