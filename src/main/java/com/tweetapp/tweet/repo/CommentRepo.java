package com.tweetapp.tweet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.tweet.entity.Comment;
@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
