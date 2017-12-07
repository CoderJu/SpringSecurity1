package com.eleven.security;


import com.eleven.model.Profileid;
import com.eleven.model.User;
import com.eleven.model.UserToProfileid;
import com.eleven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2017/11/22.
 */
@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserService userService;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if (user == null ){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassWord(),
                user.getState().equals("Active"),true,
                true,true,getGrantedAuthorities(user));

    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        /*for(UserToProfileid userToProfileid : user.getUserToProfileidHashSet()){
            System.out.println("userToProfileid : "+userToProfileid);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userToProfileid.getProfileid().getType()));
        }*/

        for(Profileid userToProfileid : user.getProfileids()){
            System.out.println("userToProfileid : "+userToProfileid);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userToProfileid.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
