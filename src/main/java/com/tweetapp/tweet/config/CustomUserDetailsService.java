package com.tweetapp.tweet.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.repo.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=repo.findUserByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
		return user;
	}

}
