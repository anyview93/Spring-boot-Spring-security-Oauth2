package com.example.oauth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private DataSource dataSource;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
             
        clients
        	.jdbc(this.dataSource)
        	.clients(new JdbcClientDetailsService(dataSource));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(userService); //配置userService 这样每次认证的时候会去检验用户是否锁定，有效等
        
    	//使用数据库来存储用户信息
//        endpoints.userDetailsService(userService)
//        		.authorizationCodeServices(authorizationCodeServices())
//        		.authenticationManager(this.authenticationManager)
//        		.tokenStore(tokenStore()).approvalStoreDisabled();
    }

    @Bean
    public TokenStore tokenStore() {
        //使用内存的tokenStore
        return new MyRedisTokenStore(connectionFactory);
    }
    
    /*//使用数据库来存储用户信息
    @Bean
    public JdbcTokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
    } */
    
    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
    return new JdbcAuthorizationCodeServices(dataSource);
    }
}
