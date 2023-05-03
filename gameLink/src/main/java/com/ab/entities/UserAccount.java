package com.ab.entities;


import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	@Column(unique= true)
	private String username;
	@Column(unique = true)
	private String email;
	@Column(length = 70)
	private String password;
	private String firstName;
	private String lastName;
	@OneToOne
	private Avatar avatarId;
	@Column(length = 2500)
	private String bio;
	@ElementCollection
    @CollectionTable(name = "user_favorite_genres")
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Set<Genre> favoriteGenres;
	@OneToMany(mappedBy = "accountId")
	private List<Connections> friendsList;
	@OneToMany(mappedBy="friendId")
	private List<Connections> friend;
	@OneToMany(mappedBy = "senderId")
	private List<Messages> sentMessages;
	@OneToMany(mappedBy = "receiverId")
	private List<Messages> receivedMessages;
	@OneToMany(mappedBy = "accountId")
	private List<Posts> posts;
	@OneToMany(mappedBy = "accountId")
	private List<Likes> likes;
	@OneToMany(mappedBy = "accountId")
	private List<Comments> comments;
	
	public UserAccount() {
		super();
	}

	public UserAccount(String username, String email, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Avatar getAvatarId() {
		return avatarId;
	}

	public void setAvatarId(Avatar avatarId) {
		this.avatarId = avatarId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Set<Genre> getFavoriteGenres() {
		return favoriteGenres;
	}

	public void setFavoriteGenres(Set<Genre> favoriteGenres) {
		this.favoriteGenres = favoriteGenres;
	}
	
	public List<Connections> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<Connections> friendsList) {
		this.friendsList = friendsList;
	}

	
	public List<Messages> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(List<Messages> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public List<Messages> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(List<Messages> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
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
	
	public List<Connections> getFriend() {
		return friend;
	}

	public void setFriend(List<Connections> friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "UserAccount [accountId=" + accountId + ", username=" + username + ", email=" + email + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", avatarId=" + avatarId + ", bio="
				+ bio + ", favoriteGenres=" + favoriteGenres;
	}
	
	
	
	
}
