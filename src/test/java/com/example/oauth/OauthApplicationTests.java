package com.example.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.management.ManagementFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthApplicationTests {

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encode = encoder.encode("123456");
		System.out.println(encode);
	}

}
