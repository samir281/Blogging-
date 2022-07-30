package com.tweetapp.tweet.payloads;

import com.sun.istack.NotNull;
import com.tweetapp.tweet.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweetDto {
	
	private int id;
	@NotNull
	private String discription;
}
