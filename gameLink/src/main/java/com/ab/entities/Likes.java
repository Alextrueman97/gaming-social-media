package com.ab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long likeId;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private UserAccount accountId;
	@ManyToOne
	@JoinColumn(name = "postId")
	private Posts postId;
	
	public Likes() {
		super();
	}

	public Likes(UserAccount accountId, Posts postId) {
		super();
		this.accountId = accountId;
		this.postId = postId;
	}

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public UserAccount getAccountId() {
		return accountId;
	}

	public void setAccountId(UserAccount accountId) {
		this.accountId = accountId;
	}

	public Posts getPostId() {
		return postId;
	}

	public void setPostId(Posts postId) {
		this.postId = postId;
	}
	
}
