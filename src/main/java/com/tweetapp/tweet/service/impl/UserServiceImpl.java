package com.tweetapp.tweet.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.payloads.UserForgetPasswordDto;
import com.tweetapp.tweet.payloads.UserLogin;
import com.tweetapp.tweet.payloads.UsersDto;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public User createUser(UsersDto usersDto) 
	{
		try {
		System.out.println(usersDto.getFirstname());
		User user= new User(usersDto.getId(),usersDto.getFirstname(),usersDto.getMiddlename(),usersDto.getLastName(),usersDto.getPhoneNumber(),
				usersDto.getUsername(),
				passwordEncoder.encode(usersDto.getPassword()));
		if(userRepo.findByusername(user.getUsername())==null) 
		{
		return userRepo.save(user);
		}
		else
			return null;
	}
		catch(Exception e)
		{
			System.out.print(e);
			System.out.println("hello");
			return null;
		}
	}
	@Override
	public String upadtePassword(UserForgetPasswordDto usersDto) {
		// TODO Auto-generated method stub
		try {
		User user=userRepo.findByusername(usersDto.getUsername());
		if(user==null)
		{
			return "Wrong Username";
		}
		else if(user.getPhoneNumber().equals(usersDto.getPhonenumber()))
		{
			int result=userRepo.updatePassword(usersDto.getUsername(),usersDto.getNewpassword());
			if(result==1)
			{
				return "Password Changed";
			}
			else
			{
				return "Something went wrong please try again1";
			}
		}
		else
		{
			return "Entered phone No. is not Linked with this Account";
		}
		}
		catch(Exception e) {
			System.out.println(e);
		return "Something went wrong please try again";
		}
	}

	@Override
	public String login(UserLogin userLogin) {
		// TODO Auto-generated method stub
		User user=userRepo.findByusername(userLogin.getUsername());
		if(user==null)
		{
			return "Wrong Username";
		}
		else if(user.getPassword().equals(passwordEncoder.encode(userLogin.getPassword())))
		{
			return "Loged in";
		}
		else
		{
			return "wrong Password";
		}
	}
	@Override
	public List<User> getall() {
		return userRepo.findAll();
	}

}
