package com.tweetapp.tweet.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
@RequestMapping("/api/v1.0/tweets")
public interface ITweetController {

	@PostMapping("/username/{username}/add")
	public ResponseEntity<TweetDto> postTweet(@PathVariable String username,@Valid @RequestBody TweetDto tweetDto);
	@GetMapping("/username/{username}")
	public ArrayList<TweetByUser> getAllTweetByUser(@PathVariable String username);
	@PutMapping("/{username}/update/{tweetid}")
	public ResponseEntity<TweetDto> updateTweet(@PathVariable String username,@PathVariable int tweetid,@Valid @RequestBody TweetDto tweetDto) throws TweetException;
	@DeleteMapping("/{username}/delete/{tweetid}")
	public ResponseEntity<String> deletTweet(@PathVariable String username,@PathVariable int tweetid);
}
