/****************************************************************************

* Copyright (c) 2016 by Accolite.com. All rights reserved

*

* Created date :: Jul 24, 2016

*

*  @author :: Mohit Devda

* ***************************************************************************

*/
package com.accolite.rest;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment {

 /** The comment. */
 String comment;

/** The person id. */
private int personId;
;

/**
 * Gets the comment.
 *
 * @return the comment
 */
public String getComment() {
	return comment;
}

/**
 * Sets the comment.
 *
 * @param comment the new comment
 */
public void setComment(String comment) {
	this.comment = comment;
}

/**
 * Gets the person id.
 *
 * @return the person id
 */
public int getPersonId() {
	return personId;
}

/**
 * Sets the person id.
 *
 * @param personId the new person id
 */
public void setPersonId(int personId) {
	this.personId = personId;
}

}
