package com.example.oauth;

import java.util.Base64;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PWDEncodingTest {
	
	/**
	 * 用户名和密码base64编码
	 * 
	 */
	@Test
	public String getBase64() {
		String client_id = "admin";
		String secret = "123456";
		String encode = Base64.getEncoder().encodeToString((client_id + ":" + secret).getBytes());
		System.out.println(encode);
		return encode;
	}
	
	@Test
	public String getBCrypt() {
		String str = "123456";
		String hashpw = BCrypt.hashpw(str, str);
		System.out.println(hashpw);
		return hashpw;
	}
}
