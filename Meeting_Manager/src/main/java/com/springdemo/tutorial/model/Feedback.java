package com.springdemo.tutorial.model;

public class Feedback {

	private int SessionID, Total;
	private double Feedback1, Feedback2, Feedback3, Feedback4;

	public int getSessionID() {
		return SessionID;
	}

	public int getTotal() {
		return Total;
	}

	public void setTotal(int Total) {
		this.Total = Total;
	}

	public void setSessionID(int SessionID) {
		this.SessionID = SessionID;
	}

	public double getFeedback1() {
		return Feedback1;
	}

	public void setFeedback1(double Feedback1) {
		this.Feedback1 = Feedback1;
	}

	public double getFeedback2() {
		return Feedback2;
	}

	public void setFeedback2(double Feedback2) {
		this.Feedback2 = Feedback2;
	}

	public double getFeedback3() {
		return Feedback3;
	}

	public void setFeedback3(double Feedback3) {
		this.Feedback3 = Feedback3;
	}

	public double getFeedback4() {
		return Feedback4;
	}

	public void setFeedback4(double Feedback4) {
		this.Feedback4 = Feedback4;
	}

	public Feedback(int SessionID) {
		this.SessionID = SessionID;
		Feedback1 = 0;
		Feedback2 = 0;
		Feedback3 = 0;
		Feedback4 = 0;
		Total = 0;
	}

	public Feedback() {
		SessionID = -1;
		Feedback1 = 0;
		Feedback2 = 0;
		Feedback3 = 0;
		Feedback4 = 0;
		Total = 0;
	}

	public Feedback(int SessionID, double Feedback1, double Feedback2, double Feedback3, double Feedback4) {
		this.SessionID = SessionID;
		this.Feedback1 = Feedback1;
		this.Feedback2 = Feedback2;
		this.Feedback3 = Feedback3;
		this.Feedback4 = Feedback4;
		Total = 1;
	}

}
