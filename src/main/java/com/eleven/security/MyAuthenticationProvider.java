package com.eleven.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by User on 2017/11/23.
 */
public class MyAuthenticationProvider implements AuthenticationProvider {

    private CustomUserDetailsService customUserDetailsService;

    public void setCustomUserDetailsService(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("user name: "+authentication.getName());

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(authentication.getName());

        //对用户名的密码进行校验
        UsernamePasswordAuthenticationToken result =  new UsernamePasswordAuthenticationToken(
                userDetails,
                authentication.getCredentials(),
                userDetails.getAuthorities()) ;
        return result;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
