package com.springdemo.tutorial.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Feedback.
 */
public class Feedback {

	/** The Total. */
	private int SessionID, Total;
	
	/** The Feedback 4. */
	private double Feedback1, Feedback2, Feedback3, Feedback4;

	/**
	 * Gets the session ID.
	 *
	 * @return the session ID
	 */
	public int getSessionID() {
		return SessionID;
	}

	/**
	 * Gets the total.
	 *
	 * @return the total
	 */
	public int getTotal() {
		return Total;
	}

	/**
	 * Sets the total.
	 *
	 * @param Total the new total
	 */
	public void setTotal(int Total) {
		this.Total = Total;
	}

	/**
	 * Sets the session ID.
	 *
	 * @param SessionID the new session ID
	 */
	public void setSessionID(int SessionID) {
		this.SessionID = SessionID;
	}

	/**
	 * Gets the feedback 1.
	 *
	 * @return the feedback 1
	 */
	public double getFeedback1() {
		return Feedback1;
	}

	/**
	 * Sets the feedback 1.
	 *
	 * @param Feedback1 the new feedback 1
	 */
	public void setFeedback1(double Feedback1) {
		this.Feedback1 = Feedback1;
	}

	/**
	 * Gets the feedback 2.
	 *
	 * @return the feedback 2
	 */
	public double getFeedback2() {
		return Feedback2;
	}

	/**
	 * Sets the feedback 2.
	 *
	 * @param Feedback2 the new feedback 2
	 */
	public void setFeedback2(double Feedback2) {
		this.Feedback2 = Feedback2;
	}

	/**
	 * Gets the feedback 3.
	 *
	 * @return the feedback 3
	 */
	public double getFeedback3() {
		return Feedback3;
	}

	/**
	 * Sets the feedback 3.
	 *
	 * @param Feedback3 the new feedback 3
	 */
	public void setFeedback3(double Feedback3) {
		this.Feedback3 = Feedback3;
	}

	/**
	 * Gets the feedback 4.
	 *
	 * @return the feedback 4
	 */
	public double getFeedback4() {
		return Feedback4;
	}

	/**
	 * Sets the feedback 4.
	 *
	 * @param Feedback4 the new feedback 4
	 */
	public void setFeedback4(double Feedback4) {
		this.Feedback4 = Feedback4;
	}

	/**
	 * Instantiates a new feedback.
	 *
	 * @param SessionID the session ID
	 */
	public Feedback(int SessionID) {
		this.SessionID = SessionID;
		Feedback1 = 0;
		Feedback2 = 0;
		Feedback3 = 0;
		Feedback4 = 0;
		Total = 0;
	}

	/**
	 * Instantiates a new feedback.
	 */
	public Feedback() {
		SessionID = -1;
		Feedback1 = 0;
		Feedback2 = 0;
		Feedback3 = 0;
		Feedback4 = 0;
		Total = 0;
	}

	/**
	 * Instantiates a new feedback.
	 *
	 * @param SessionID the session ID
	 * @param Feedback1 the feedback 1
	 * @param Feedback2 the feedback 2
	 * @param Feedback3 the feedback 3
	 * @param Feedback4 the feedback 4
	 */
	public Feedback(int SessionID, double Feedback1, double Feedback2, double Feedback3, double Feedback4) {
		this.SessionID = SessionID;
		this.Feedback1 = Feedback1;
		this.Feedback2 = Feedback2;
		this.Feedback3 = Feedback3;
		this.Feedback4 = Feedback4;
		Total = 1;
	}

}
