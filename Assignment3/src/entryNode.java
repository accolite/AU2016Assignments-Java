
// TODO: Auto-generated Javadoc
/**
 * The Class entryNode.
 */
class entryNode {
		
		/** The key value. */
		Object keyValue;
	
	/** The Value. */
	String Value;
	
	/** The next. */
	entryNode next;	
	/** The previous. */
	entryNode previous;
	
	/** The link next. */
	entryNode linkNext;
	
	/** The link previous. */
	entryNode linkPrevious;
	
	/**
	 * Instantiates a new entry node.
	 */
	public entryNode() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new entry node.
	 *
	 * @param keyvalue the keyvalue
	 * @param value the value
	 */
	public entryNode(Object keyvalue,String value)
	{
		this.keyValue=keyvalue;
		this.Value=value;
	}
	
}
