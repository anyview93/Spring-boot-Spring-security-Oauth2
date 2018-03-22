package com.example.oauth.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 对外开放的接口
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.oauth.pojo.MyUserDetails;
import com.example.oauth.pojo.User;

@RestController
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private TokenStore tokenStore;
    
    /**
     * 密码授权
     * @param auth
     * @return
     */
    @PostMapping("/barPwd")
    public String barPwd(@RequestHeader("Authorization") String auth) {
    	Object principal = tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        System.out.println(principal);
    	MyUserDetails userDetails = (MyUserDetails) principal;
        User user = userDetails.getUser();
        return user.getUserName() + ":" + user.getPassword();

    }
    
    /**
     * 客户端授权
     * @param auth
     * @return
     */
    @PostMapping("/barCli")
    public String barCli(@RequestHeader("Authorization") String auth) {
    	Object principal = tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
        System.out.println(principal);
        return principal.toString();

    }
    
    /**
     * 
     * @return
     */
    @GetMapping("/productSelect")
    public String productSelect() {
    	logger.info("产品查询");
    	return "success";
    }
}
