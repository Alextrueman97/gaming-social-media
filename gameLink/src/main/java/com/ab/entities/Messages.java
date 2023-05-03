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
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long messageId;
	@ManyToOne
	@JoinColumn(name = "senderId")
	private UserAccount senderId;
	@ManyToOne
	@JoinColumn(name = "receiverId")
	private UserAccount receiverId;
	@Column(length = 1500)
	private String message;
	private LocalDateTime dateTime;
	
	public Messages() {
		super();
	}

	public Messages(UserAccount senderId, UserAccount receiverId, String message, LocalDateTime dateTime) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.message = message;
		this.dateTime = dateTime;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public UserAccount getSenderId() {
		return senderId;
	}

	public void setSenderId(UserAccount senderId) {
		this.senderId = senderId;
	}

	public UserAccount getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(UserAccount receiverId) {
		this.receiverId = receiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
