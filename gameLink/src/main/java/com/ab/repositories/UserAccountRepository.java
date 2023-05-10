package com.ab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ab.entities.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>{

	@Query(value = "select new UserAccount(ua.accountId, ua.username, ua.email, ua.password, ua.firstName, ua.lastName) from UserAccount ua where ua.username = :username")
	public UserAccount findByUsername(@Param("username") String username);

}
