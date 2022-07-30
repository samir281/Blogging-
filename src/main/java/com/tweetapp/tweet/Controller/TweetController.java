package com.tweetapp.tweet.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.service.ITweetService;
@RestController
public class TweetController implements ITweetController {
	
	@Autowired
	private ITweetService iTweetService;
	@Override
	public ResponseEntity<TweetDto> postTweet(String username, @Valid TweetDto tweetDto) {
		// TODO Auto-generated method stub
		TweetDto response=iTweetService.createTweet(tweetDto, username);
		return new ResponseEntity<TweetDto>(response,HttpStatus.OK);
	}


	@Override
	public ArrayList<TweetByUser> getAllTweetByUser(String username) {
		// TODO Auto-generated method stub
		return iTweetService.getalltweetbyuser(username);
	}

	@Override
	public ResponseEntity<TweetDto> updateTweet(String username, int tweetid,TweetDto tweetDto){
		// TODO Auto-generated method stub
		try {
		TweetDto response=iTweetService.updateTweet(tweetDto, tweetid,username);
		return new ResponseEntity<TweetDto>(response,HttpStatus.OK);
		}
		catch (TweetException e) {
			TweetDto tweetDto2=new TweetDto();
			tweetDto2.setDiscription(e.getMessage());
			return new ResponseEntity<TweetDto>(tweetDto2,HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<String> deletTweet(String username, int tweetid){
		// TODO Auto-generated method stub
		try {
		String response=iTweetService.deletPost(tweetid,username);
		return new ResponseEntity<String>(response,HttpStatus.OK);
		}
		catch (TweetException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

}
