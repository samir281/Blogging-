package com.tweetapp.tweet.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.payloads.CommentDto;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.service.ICommentService;
@RestController
public class CommentController implements ICommentController {

	@Autowired
	ICommentService commentService;
	@Override
	public ResponseEntity<String> replytoTweet(String username, int id, @Valid CommentDto commentDto) {
		// TODO Auto-generated method stub
		String res=commentService.replyToTweet(commentDto, username, id);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}

}
