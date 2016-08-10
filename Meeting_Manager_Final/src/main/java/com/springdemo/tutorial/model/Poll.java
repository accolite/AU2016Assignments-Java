package com.springdemo.tutorial.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Poll.
 */
public class Poll {
	
	/** The poll ID. */
	private int pollID;
	
	/** The q. */
	private String q;
	
	/** The o 1. */
	private String o1;
	
	/** The session ID. */
	private int sessionID;
	
	/**
	 * Gets the session ID.
	 *
	 * @return the sessionID
	 */
	public int getSessionID() {
		return sessionID;
	}

	/**
	 * Sets the session ID.
	 *
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * Gets the session name.
	 *
	 * @return the sessionName
	 */
	public String getSessionName() {
		return sessionName;
	}

	/**
	 * Sets the session name.
	 *
	 * @param sessionName the sessionName to set
	 */
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	/** The session name. */
	private String sessionName;

	/**
	 * Instantiates a new poll.
	 */
	public Poll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The o 2. */
	private String o2;
	
	/** The o 3. */
	private String o3;
	
	/** The o 4. */
	private String o4;

	/**
	 * Gets the poll ID.
	 *
	 * @return the pollID
	 */
	public int getPollID() {
		return pollID;
	}

	/**
	 * Instantiates a new poll.
	 *
	 * @param pollID the poll ID
	 * @param q the q
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @param o3 the o 3
	 * @param o4 the o 4
	 */
	public Poll(int pollID, String q, String o1, String o2, String o3, String o4) {
		super();
		this.pollID = pollID;
		this.q = q;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.o4 = o4;
	}

	/**
	 * Sets the poll ID.
	 *
	 * @param pollID            the pollID to set
	 */
	public void setPollID(int pollID) {
		this.pollID = pollID;
	}

	/**
	 * Gets the q.
	 *
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * Sets the q.
	 *
	 * @param q            the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * Gets the o1.
	 *
	 * @return the o1
	 */
	public String getO1() {
		return o1;
	}

	/**
	 * Sets the o1.
	 *
	 * @param o1            the o1 to set
	 */
	public void setO1(String o1) {
		this.o1 = o1;
	}

	/**
	 * Gets the o2.
	 *
	 * @return the o2
	 */
	public String getO2() {
		return o2;
	}

	/**
	 * Sets the o2.
	 *
	 * @param o2            the o2 to set
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}

	/**
	 * Gets the o3.
	 *
	 * @return the o3
	 */
	public String getO3() {
		return o3;
	}

	/**
	 * Sets the o3.
	 *
	 * @param o3            the o3 to set
	 */
	public void setO3(String o3) {
		this.o3 = o3;
	}

	/**
	 * Gets the o4.
	 *
	 * @return the o4
	 */
	public String getO4() {
		return o4;
	}

	/**
	 * Sets the o4.
	 *
	 * @param o4            the o4 to set
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}

}
