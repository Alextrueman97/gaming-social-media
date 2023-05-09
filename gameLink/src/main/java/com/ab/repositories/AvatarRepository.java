package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ab.entities.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Integer> {

}
