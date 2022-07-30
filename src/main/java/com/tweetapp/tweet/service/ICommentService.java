package com.tweetapp.tweet.service;

import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.CommentDto;

public interface ICommentService {
	
	//String replyToTweet(CommentDto commentDto) throws TweetException;

	String replyToTweet(CommentDto commentDto, String username,int id);
	
}
