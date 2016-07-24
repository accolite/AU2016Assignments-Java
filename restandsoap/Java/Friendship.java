package com.accolite.Messanger.messanger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Friendship {
	private int friendship_id;
	private int friend1_id;
	private int friend2_id;
	
	public Friendship() {
		
	}
	
	public Friendship(int friendship_id, int friend1_id, int friend2_id) {
		this.friendship_id = friendship_id;
		this.friend1_id = friend1_id;
		this.friend2_id = friend2_id;
	}

	public int getFriendship_id() {
		return friendship_id;
	}

	public void setFriendship_id(int friendship_id) {
		this.friendship_id = friendship_id;
	}

	public int getFriend1_id() {
		return friend1_id;
	}

	public void setFriend1_id(int friend1_id) {
		this.friend1_id = friend1_id;
	}

	public int getFriend2_id() {
		return friend2_id;
	}

	public void setFriend2_id(int friend2_id) {
		this.friend2_id = friend2_id;
	}
	
}
