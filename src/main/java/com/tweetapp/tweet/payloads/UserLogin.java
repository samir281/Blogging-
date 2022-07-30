package com.tweetapp.tweet.payloads;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLogin {
	@NotNull
	@Email
	private String username;
	@NotNull
	private String password;
}
