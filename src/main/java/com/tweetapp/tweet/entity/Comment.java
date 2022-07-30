package com.tweetapp.tweet.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Comment{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@Size(max = 144)
	private String reply;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Tweet tweet;
	
	private LocalDateTime date;
}
