package com.tweetapp.tweet.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.tweet.entity.Comment;
import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.repo.CommentRepo;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.ICommentService;
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	TweetRepo tweetrepo;
	@Autowired
	UserRepo userrepo;
	@Autowired
	CommentRepo commentRepo;
	@Override
	public String replyToTweet(CommentDto commentDto, String username,int id) {
		// TODO Auto-generated method stub
		Comment comment=new Comment();
		comment.setReply(commentDto.getReply());
		LocalDateTime dtm = LocalDateTime.now(); 
		comment.setDate(dtm);
		Optional<Tweet> tweet=tweetrepo.findById(id);
		comment.setTweet(tweet.get());
		commentRepo.save(comment);
		return "Done";
	}

}
