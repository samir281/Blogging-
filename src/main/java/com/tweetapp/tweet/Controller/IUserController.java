package com.tweetapp.tweet.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;

@RequestMapping("/api/v1.0/tweets")
public interface IUserController {
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@Valid @RequestBody UsersDto userDto);
	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody UserLogin userLogin) throws Exception;
	@PostMapping("/updatepassword")
	public ResponseEntity<String> updatepasword(@Valid @RequestBody UserForgetPasswordDto userForgetPasswordDto);
	@GetMapping("/getallusers")
	public List<User> getallusers();
}
