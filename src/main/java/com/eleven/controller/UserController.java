package com.eleven.controller;

import com.eleven.model.User;
import com.eleven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 2017/11/21.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public void test(){
        User user = userService.findByUserName("yiibai");
        System.out.println(">>>>>>>>>>>>>>>>>>>>"+user);
    }
}
