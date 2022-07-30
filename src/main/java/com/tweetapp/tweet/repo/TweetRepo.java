package com.tweetapp.tweet.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.TweetDto;

@Repository
public interface TweetRepo extends JpaRepository<Tweet, Integer> {
	
	List<Tweet> findByuser(User user);
//	@Query("select * from tweet")
//	public List<Tweet> findAllTweet();
}
