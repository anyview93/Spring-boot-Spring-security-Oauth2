package com.example.oauth.config;

/**
 * 未知用途
 */
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class GlobalAuthenticationConfigurer extends GlobalAuthenticationConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(GlobalAuthenticationConfigurer.class);
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        //TODO:use md5
    	logger.info("密码校验");
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        return charSequence.toString().equals(s);
                    }
                });
    }
}*/
