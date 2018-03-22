package com.example.oauth.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.oauth.pojo.MyUserDetails;
import com.example.oauth.pojo.User;
import com.example.oauth.service.UserService;

@Primary
@Service("userService")
public class UserServiceImpl implements UserService {
	
    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User(1, "test-user1", "123451"));
        users.add(new User(2, "test-user2", "123452"));
        users.add(new User(3, "test-user3", "123453"));
        users.add(new User(4, "test-user4", "123454"));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	Optional<User> userWrapper = users.stream()
                .filter((u) -> u.getUserName().equals(s))
                .findFirst();
        if (!userWrapper.isPresent())
            throw new UsernameNotFoundException("there's no user founded!");
        else
        	System.out.println(userWrapper.get());
            return new MyUserDetails(userWrapper.get());
    }
}
