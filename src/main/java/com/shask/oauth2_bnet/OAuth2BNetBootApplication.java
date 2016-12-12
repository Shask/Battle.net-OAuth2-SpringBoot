package com.shask.oauth2_bnet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;


@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class OAuth2BNetBootApplication extends WebSecurityConfigurerAdapter {
   final private static Logger logger = LoggerFactory.getLogger(OAuth2BNetBootApplication.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        logger.info(principal.toString());

        //If you want to save user Battle tag and/or id, you can access those info like this :
        HashMap<String,Object> details = (LinkedHashMap<String,Object>)((OAuth2Authentication)principal).getUserAuthentication().getDetails();
        String battleTag = (String) details.get("battletag");
        Integer id =(Integer) details.get("id");


        logger.info("id is : " + id);
        logger.info("battleTag is : " + battleTag);


        return principal;
    }

    public static void main(String[] args) {
        SpringApplication.run(OAuth2BNetBootApplication.class, args);
    }



}
