package com.tweetapp.tweet.service;

import java.util.ArrayList;
import java.util.List;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;

public interface ITweetService {
	
//	ArrayList<Tweet> getAllTweet();
	TweetDto createTweet(TweetDto tweetDto,String username);
	ArrayList<TweetByUser> getalltweetbyuser(String username);
	TweetDto updateTweet(TweetDto tweetDto,int  tweetid,String username) throws TweetException;
	String deletPost(int tweetid,String Username) throws TweetException;
}