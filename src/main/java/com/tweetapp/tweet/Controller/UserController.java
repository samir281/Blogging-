package com.tweetapp.tweet.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.startup.UserDatabase;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.service.IUserService;
import com.tweetapp.tweet.service.impl.UserServiceImpl;

@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public ResponseEntity<String> signUp(@Valid UsersDto userDto) {
		// TODO Auto-generated method stub
		User usersDto=iUserService.createUser(userDto);
		System.out.println(userDto.getFirstname());
		if(usersDto!=null) {
			System.out.println("hello");
			String response1="created";
		return new ResponseEntity<String>(response1, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Some thing got wrong", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> login(@Valid UserLogin userLogin) throws Exception{
		org.springframework.security.core.Authentication authObject = null;
		try {
			authObject=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
			//SecurityContextHolder.getContext().setAuthentication(authObject);
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid credentials");
		}
		
		return new ResponseEntity<String>("Logged in",HttpStatus.OK);
	}

	@Override
	public List<User> getallusers() {
		return iUserService.getall();
	}

	@Override
	public ResponseEntity<String> updatepasword(@Valid UserForgetPasswordDto userForgetPasswordDto) {
		String response=iUserService.upadtePassword(userForgetPasswordDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
