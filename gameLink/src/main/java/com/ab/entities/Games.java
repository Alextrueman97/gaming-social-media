package com.ab.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Games {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gameId;
	private String gameName;
	private Genre genre;
	@OneToMany(mappedBy = "gameId")
	private List<Posts> posts;
	
	public Games() {
		super();
	}

	public Games(String gameName, Genre genre) {
		super();
		this.gameName = gameName;
		this.genre = genre;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public List<Posts> getPosts() {
		return posts;
	}

	public void setPosts(List<Posts> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Games [gameId=" + gameId + ", gameName=" + gameName + ", genre=" + genre + "]";
	}
	
	
}
