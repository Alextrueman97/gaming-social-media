package com.ab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class usersGames {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long usersGamesId;
	@ManyToOne
	@JoinColumn(name="accountId")
	private UserAccount accountId;
	@ManyToOne
	@JoinColumn(name="gameId")
	private Games gameId;
	
	public usersGames() {
		super();
	}

	public usersGames(UserAccount accountId, Games gameId) {
		super();
		this.accountId = accountId;
		this.gameId = gameId;
	}

	public long getUsersGamesId() {
		return usersGamesId;
	}

	public void setUsersGamesId(long usersGamesId) {
		this.usersGamesId = usersGamesId;
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

	@Override
	public String toString() {
		return "usersGames [usersGamesId=" + usersGamesId + ", accountId=" + accountId + ", gameId=" + gameId + "]";
	}
	
	
	
}
