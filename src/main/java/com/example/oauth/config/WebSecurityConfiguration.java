package com.example.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	
	/*
	 //需要用户授权时配置
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
        .inMemoryAuthentication()
        .passwordEncoder(new MyPasswordEncoder())//在此处应用自定义PasswordEncoder
        .withUser("user")
        .password("password")
        .roles("USER");
  }*/
}
