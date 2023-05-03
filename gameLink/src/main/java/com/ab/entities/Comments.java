package com.ab.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private UserAccount accountId;
	@ManyToOne
	@JoinColumn(name = "postId")
	private Posts postId;
	@Column(length = 2500)
	private String content;
	private LocalDateTime dateTime;
	
	public Comments() {
		super();
	}

	public Comments(UserAccount accountId, Posts postId, String content, LocalDateTime dateTime) {
		super();
		this.accountId = accountId;
		this.postId = postId;
		this.content = content;
		this.dateTime = dateTime;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
