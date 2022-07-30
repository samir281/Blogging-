package com.tweetapp.tweet.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweet.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findUserByUsername(String username);
	User findByusername(String username);
	@Transactional
	@Modifying()
	@Query("UPDATE User c SET c.password = :password WHERE c.username = :username")
	int updatePassword(@Param("username") String username,@Param("password") String password);
}
