package com.ab.entities;

import java.io.File;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Avatar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avatarId;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private File avatar;
	
	public Avatar() {
		super();
	}
	
	public Avatar(File avatar) {
		super();
		this.avatar = avatar;
	}

	public int getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(int avatarId) {
		this.avatarId = avatarId;
	}
	public File getAvatar() {
		return avatar;
	}
	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}
	
	
}
