package com.tweetapp.tweet.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * http. csrf(). disable(). authorizeHttpRequests(). anyRequest().
		 * authenticated(). and(). httpBasic();
		 */
		/*
		 * http .csrf().disable()
		 * .authorizeRequests().antMatchers("/api/v1.0/tweets/signup") .permitAll()
		 * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
		 * .permitAll() // .and() .logout() .invalidateHttpSession(true)
		 * .clearAuthentication(true) .permitAll();
		 */
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v1.0/tweets/signup", "/api/v1.0/tweets/login","/api/v1.0/tweets/updatepassword").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
