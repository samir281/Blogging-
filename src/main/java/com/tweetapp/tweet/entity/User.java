package com.tweetapp.tweet.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
@AllArgsConstructor
public class User implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String Firstname;
	
	private String middlename=null;
	
	@NotNull
	private String LastName;
	
	//@Size(max = 10)
	private String phoneNumber;
	
	@NotNull
	@Email
	private String username;
	
	@NotNull
	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Tweet> tweetJpaList;
	
	public User(int id,String Firstname,String Middlename,String Lastname,String phone,String username,String password)
	{
		this.id=id;
		this.Firstname=Firstname;
		this.middlename=Middlename;
		this.LastName=Lastname;
		this.phoneNumber=phone;
		this.username=username;
		this.password=password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
