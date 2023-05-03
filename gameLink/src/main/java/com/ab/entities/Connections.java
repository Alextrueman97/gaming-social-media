package com.ab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Connections {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long connectionId;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private UserAccount accountId;
	@ManyToOne
	@JoinColumn(name = "friendId")
	private UserAccount friendId;
	
	public Connections() {
		super();
	}

	public Connections(UserAccount accountId, UserAccount friendId) {
		super();
		this.accountId = accountId;
		this.friendId = friendId;
	}

	public long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(long connectionId) {
		this.connectionId = connectionId;
	}

	public UserAccount getAccountId() {
		return accountId;
	}

	public void setAccountId(UserAccount accountId) {
		this.accountId = accountId;
	}

	public UserAccount getFriendId() {
		return friendId;
	}

	public void setFriendId(UserAccount friendId) {
		this.friendId = friendId;
	}

	@Override
	public String toString() {
		return "Connections [connectionId=" + connectionId + ", accountId=" + accountId + ", friendId=" + friendId
				+ "]";
	}
	
	
}
