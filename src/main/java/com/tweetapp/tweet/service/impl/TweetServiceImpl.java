//package com.tweetapp.tweet.service.impl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.tags.form.TagWriter;
//
//import com.tweetapp.tweet.entity.Tweet;
//import com.tweetapp.tweet.entity.User;
//import com.tweetapp.tweet.exception.TweetException;
//import com.tweetapp.tweet.payloads.TweetByUser;
//import com.tweetapp.tweet.payloads.TweetDto;
//import com.tweetapp.tweet.repo.TweetRepo;
//import com.tweetapp.tweet.repo.UserRepo;
//import com.tweetapp.tweet.service.ITweetService;
//
//@Service
//public class TweetServiceImpl implements ITweetService {
//
//	@Autowired
//	TweetRepo tweetRepo;
//	@Autowired
//	UserRepo userRepo;
//	@Override
//	public ArrayList<TweetDto> getAllTweet() {
//		// TODO Auto-generated method stub
//		List<Tweet> tweet=tweetRepo.findAll();
//		ArrayList<TweetDto> tweetDtos=new ArrayList<TweetDto>();
//		System.out.println("hello");
//		tweet.stream().map((singletweet)->tweetDtos.add(new TweetDto(singletweet.getId(),
//				singletweet.getDescription(),singletweet.getUser()))).collect(Collectors.toList());
//		//return (ArrayList<Tweet>) tweetRepo.findAll();
//		System.out.println(tweetDtos.get(0));
//		return tweetDtos;
//	}
//
//	@Override
//	public TweetDto createTweet(TweetDto tweetDto, String username) {
//		// TODO Auto-generated method stub
//		User user=userRepo.findByusername(username);
//		Tweet tweet=new Tweet();
//		tweet.setDate(new Date());
//		tweet.setDescription(tweetDto.getDiscription());
//		tweet.setId(tweetDto.getId());
//		tweet.setUser(user);
//		Tweet tweet2=tweetRepo.save(tweet);
//		TweetDto result=new TweetDto(tweet2.getId(),tweet.getDescription(),tweet2.getUser());
//		return result;
//	}
//
//	@Override
//	public ArrayList<TweetByUser> getalltweetbyuser(String username) {
//		// TODO Auto-generated method stub
//		User user=userRepo.findByusername(username);
//		if(user!=null)
//		{
//			
//			List<Tweet> tweets=tweetRepo.findByuser(user);
//			ArrayList<TweetByUser> listofTweets=new ArrayList<TweetByUser>();
//			for(Tweet i:tweets)
//			{
//				TweetByUser temp=new TweetByUser(i.getId(),i.getDescription(),i.getUser().getUsername(),i.getDate());
//				listofTweets.add(temp);
//			}
//			return listofTweets;
//		}
//		else {
//		return null;}
//	}
//
//	@Override
//	public TweetDto updateTweet(TweetDto tweetDto, int tweetid) throws TweetException {
//		// TODO Auto-generated method stub
//		Tweet tweet=this.tweetRepo.findById(tweetid).orElseThrow(()-> new TweetException("This tweet "+tweetid+" is not persent"));
//		tweet.setDescription(tweetDto.getDiscription());
//		TweetDto tweetDto2=new TweetDto();
//		try {
//		this.tweetRepo.save(tweet);
//		tweetDto2.setDiscription(tweet.getDescription());
//		tweetDto2.setId(tweet.getId());
//		return tweetDto2;
//		}
//		catch(Exception e)
//		{
//			return tweetDto2;
//		}
//	}
//
//	@Override
//	public String deletPost(int tweetid) throws TweetException {
//		// TODO Auto-generated method stub
//		Tweet tweet=this.tweetRepo.findById(tweetid).orElseThrow(()-> new TweetException("This tweet "+tweetid+" is not persent"));
//		this.tweetRepo.delete(tweet);
//		return "Tweet Deleted";
//	}
//
//}
package com.tweetapp.tweet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.TagWriter;

import com.tweetapp.tweet.entity.Tweet;
import com.tweetapp.tweet.entity.User;
import com.tweetapp.tweet.exception.TweetException;
import com.tweetapp.tweet.payloads.TweetByUser;
import com.tweetapp.tweet.payloads.TweetDto;
import com.tweetapp.tweet.repo.TweetRepo;
import com.tweetapp.tweet.repo.UserRepo;
import com.tweetapp.tweet.service.ITweetService;

@Service
public class TweetServiceImpl implements ITweetService {

	@Autowired
	TweetRepo tweetRepo;
	@Autowired
	UserRepo userRepo;
//	@Override
//	public ArrayList<Tweet> getAllTweet() {
//		// TODO Auto-generated method stub
//		return (ArrayList<Tweet>) tweetRepo.findAll();
//	}

	@Override
	public TweetDto createTweet(TweetDto tweetDto, String username) {
		// TODO Auto-generated method stub
		User user=userRepo.findByusername(username);
		Tweet tweet=new Tweet();
		tweet.setDate(new Date());
		tweet.setDescription(tweetDto.getDiscription());
		tweet.setId(tweetDto.getId());
		tweet.setUser(user);
		Tweet tweet2=tweetRepo.save(tweet);
		TweetDto result=new TweetDto(tweet2.getId(),tweet.getDescription());
		return result;
	}

	@Override
	public ArrayList<TweetByUser> getalltweetbyuser(String username) {
		// TODO Auto-generated method stub
		User user=userRepo.findByusername(username);
		if(user!=null)
		{
			
			List<Tweet> tweets=tweetRepo.findByuser(user);
			ArrayList<TweetByUser> listofTweets=new ArrayList<TweetByUser>();
			for(Tweet i:tweets)
			{
				TweetByUser temp=new TweetByUser(i.getId(),i.getDescription(),i.getUser().getUsername(),i.getDate());
				listofTweets.add(temp);
			}
			return listofTweets;
		}
		else {
		return null;}
	}

	@Override
	public TweetDto updateTweet(TweetDto tweetDto, int tweetid,String username) throws TweetException {
		// TODO Auto-generated method stub
		Tweet tweet=this.tweetRepo.findById(tweetid).orElseThrow(()-> new TweetException("This tweet "+tweetid+" is not persent"));
		User user=userRepo.findUserByUsername(username).orElseThrow(()-> new TweetException("This Username is not persent"));
		if(user.getUsername().equals(tweet.getUser().getUsername())) {
		tweet.setDescription(tweetDto.getDiscription());
		TweetDto tweetDto2=new TweetDto();
		try {
		this.tweetRepo.save(tweet);
		tweetDto2.setDiscription(tweet.getDescription());
		tweetDto2.setId(tweet.getId());
		return tweetDto2;
		}
		catch(Exception e)
		{
			return tweetDto2;
		}
		}
		else
		{
			System.out.println("Hello");
			throw new TweetException("Enter valid username and tweet id");
		}
	}

	@Override
	public String deletPost(int tweetid,String Username) throws TweetException {
		// TODO Auto-generated method stub
		Tweet tweet=this.tweetRepo.findById(tweetid).orElseThrow(()-> new TweetException("This tweet "+tweetid+" is not persent"));
		User user=userRepo.findUserByUsername(Username).orElseThrow(()-> new TweetException("This Username is not persent"));
		if(user.getUsername().equals(tweet.getUser().getUsername())) {
		this.tweetRepo.delete(tweet);
		}
		else
		{
			throw new TweetException("Enter Valid username");
		}
		return "Tweet Deleted";
	}

}
