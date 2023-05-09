package com.ab.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.repositories.AvatarRepository;

@Service
public class AvatarService {

	
	@Autowired
	private AvatarRepository avatarRepository;
	
	public List<String> getAllAvatars(){
		List<String> avatarUrls = null;
		try {
			avatarUrls = Files.readAllLines(new File("files/avatars.txt").toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return avatarUrls;
	}
	
	
}
