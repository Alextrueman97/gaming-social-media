package com.ab.entities;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private UserAccount accountId;
	@ManyToOne
	@JoinColumn(name = "gameId")
	private Games gameId;
	@Column(length = 2500)
	private String content;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private File image;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private File video;
	private LocalDateTime dateTime;
	@OneToMany(mappedBy = "postId")
	private List<Likes> likes;
	@OneToMany(mappedBy = "postId")
	private List<Comments> comments;
	
	public Posts() {
		super();
	}

	public Posts(UserAccount accountId, Games gameId, String content, File image, File video, LocalDateTime dateTime) {
		super();
		this.accountId = accountId;
		this.gameId = gameId;
		this.content = content;
		this.image = image;
		this.video = video;
		this.dateTime = dateTime;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public UserAccount getAccountId() {
		return accountId;
	}

	public void setAccountId(UserAccount accountId) {
		this.accountId = accountId;
	}

	public Games getGameId() {
		return gameId;
	}

	public void setGameId(Games gameId) {
		this.gameId = gameId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getVideo() {
		return video;
	}

	public void setVideo(File video) {
		this.video = video;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", accountId=" + accountId + ", gameId=" + gameId + ", content=" + content
				+ ", image=" + image + ", video=" + video + ", dateTime=" + dateTime + "]";
	}
	
	
}
