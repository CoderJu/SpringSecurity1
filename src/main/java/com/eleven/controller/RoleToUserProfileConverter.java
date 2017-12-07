package com.eleven.controller;

import com.eleven.model.Profileid;
import com.eleven.model.UserToProfileid;
import com.eleven.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/12/2.
 */
@Component
public class RoleToUserProfileConverter  implements Converter<Object ,Profileid>{


    @Autowired
    private ProfileService profileService;

    /*public Profileid convert(Object  o) {
        Integer id = Integer.parseInt((String) o);
        Profileid profileid= profileService.findById(id);
        System.out.println("UserToProfileid : "+profileid);
        return profileid;
    }*/


/*    public UserToProfileid convert(Object  o) {
        UserToProfileid userToProfileid = new UserToProfileid();
        Integer id = Integer.parseInt((String) o);
        Profileid profileid= profileService.findById(id);
        userToProfileid.setProfileid(profileid);
        System.out.println("UserToProfileid : "+userToProfileid);
        return userToProfileid;
    }*/

    public Profileid convert(Object  o) {
        Profileid profileid = new Profileid();
        Integer id = Integer.parseInt((String) o);
         profileid= profileService.findById(id);
        System.out.println("UserToProfileid : "+profileid);
        return profileid;
    }
}
