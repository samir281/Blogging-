package com.tweetapp.tweet.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TWEET_ID")
	private Integer id;

	@Column(name = "tweet_description")
	private String description;
	
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	@OneToMany
	private List<Comment> comments;
}
