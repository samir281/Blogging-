package com.tweetapp.tweet.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.StandardException;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TweetByUser {
	private int id;
	private String descip;
	private String username;
	private Date date;
}
