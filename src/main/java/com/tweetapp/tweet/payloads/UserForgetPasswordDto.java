package com.tweetapp.tweet.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class UserForgetPasswordDto {
	@NotNull
	@Email
	private String username;
	@NotNull
	private String newpassword;
	@NumberFormat
//	@Size(max=10)
	private long phonenumber;
}
