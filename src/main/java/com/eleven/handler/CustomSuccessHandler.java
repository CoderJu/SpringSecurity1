package com.eleven.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 2017/11/28.
 */

public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication) throws IOException {
        System.out.println("111111111111111111111111111");
        String targetUrl = determineTargetUrl(authentication);
        System.out.println("targetUrl>>>>>>>>>>>>>>>>>>>"+targetUrl);
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
    }


    protected String determineTargetUrl(Authentication authentication){

        String url = "";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<String>();

        for( GrantedAuthority a: authorities) {
            roles.add(a.getAuthority());
        }
        if (isUser(roles)){
            url="/home";
        }else if (isAdmin(roles)){
            url="/admin";
        }else if (isDba(roles)){

            url="/dba";
        }else {
            url="/roles";
        }
        return url;
    }


    private boolean isUser(List<String> roles){
        if (roles.contains("ROLE_USER")){
            return true;
        }
        return false;
    }

    private boolean isAdmin(List<String> roles){
        if (roles.contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }

    private boolean isDba(List<String> roles){
        if (roles.contains("ROLE_DBA")){
            return true;
        }
        return false;
    }
}
