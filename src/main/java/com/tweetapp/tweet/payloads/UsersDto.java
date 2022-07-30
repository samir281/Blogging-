package com.tweetapp.tweet.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {
	private int id;
	@NotNull
	private String Firstname;
	
	private String middlename;
	@NotNull
	private String LastName;
	
	//@Size(max = 10)
	private String phoneNumber;
	@NotNull
	@Email
	private String username;
	@NotNull
	private String password;
}
