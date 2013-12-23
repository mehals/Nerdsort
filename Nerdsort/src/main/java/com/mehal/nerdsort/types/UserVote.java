package com.mehal.nerdsort.types;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user_ordering")
public class UserVote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3583805248788592902L;
	
	@Id
	@GeneratedValue
	@Column (name="user_ordering_id")
	private int userOrderingId;
	
	@Column(name="list_id")
	private int listId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_ordering")
	private String userOrdering;
	
	public UserVote() {
		
	}

	public int getUserOrderingId() {
		return userOrderingId;
	}

	public void setUserOrderingId(int userOrderingId) {
		this.userOrderingId = userOrderingId;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserOrdering() {
		return userOrdering;
	}

	public void setUserOrdering(String userOrdering) {
		this.userOrdering = userOrdering;
	}


}
