package com.accolite.jaxb;
/****************************************************************************
* Copyright (c) 2016 by Accolite.com. All rights reserved
* Created date :: Jul 19, 2016
*  @author :: Lokesh K
* ***************************************************************************
*/
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

// TODO: Auto-generated Javadoc
/**
 * The Class Birthday.
 */
@XmlType
public class Birthday {
	
	/**
	 * Instantiates a new birthday.
	 */
	public Birthday() {
		super();
	}

	/** The year. */
	private int year;
	
	/** The month. */
	private int month;
	
	/** The day. */
	private int day;

	/**
	 * Instantiates a new birthday.
	 *
	 * @param year the year
	 * @param month the month
	 * @param day the day
	 */
	public Birthday(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	@XmlElement
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	@XmlElement
	public int getMonth() {
		return month;
	}

	/**
	 * Sets the month.
	 *
	 * @param month the new month
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Gets the day.
	 *
	 * @return the day
	 */
	@XmlElement
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day.
	 *
	 * @param day the new day
	 */
	public void setDay(int day) {
		this.day = day;
	}
}
