package com.springdemo.tutorial.model;

public class Poll {
	private int pollID;
	private String q;
	private String o1;
	private int sessionID;
	/**
	 * @return the sessionID
	 */
	public int getSessionID() {
		return sessionID;
	}

	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * @return the sessionName
	 */
	public String getSessionName() {
		return sessionName;
	}

	/**
	 * @param sessionName the sessionName to set
	 */
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	private String sessionName;

	public Poll() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String o2;
	private String o3;
	private String o4;

	/**
	 * @return the pollID
	 */
	public int getPollID() {
		return pollID;
	}

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
	 * @param pollID
	 *            the pollID to set
	 */
	public void setPollID(int pollID) {
		this.pollID = pollID;
	}

	/**
	 * @return the q
	 */
	public String getQ() {
		return q;
	}

	/**
	 * @param q
	 *            the q to set
	 */
	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * @return the o1
	 */
	public String getO1() {
		return o1;
	}

	/**
	 * @param o1
	 *            the o1 to set
	 */
	public void setO1(String o1) {
		this.o1 = o1;
	}

	/**
	 * @return the o2
	 */
	public String getO2() {
		return o2;
	}

	/**
	 * @param o2
	 *            the o2 to set
	 */
	public void setO2(String o2) {
		this.o2 = o2;
	}

	/**
	 * @return the o3
	 */
	public String getO3() {
		return o3;
	}

	/**
	 * @param o3
	 *            the o3 to set
	 */
	public void setO3(String o3) {
		this.o3 = o3;
	}

	/**
	 * @return the o4
	 */
	public String getO4() {
		return o4;
	}

	/**
	 * @param o4
	 *            the o4 to set
	 */
	public void setO4(String o4) {
		this.o4 = o4;
	}

}
