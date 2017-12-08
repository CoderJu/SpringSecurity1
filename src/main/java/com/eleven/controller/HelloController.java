package com.eleven.controller;

import com.eleven.model.Profileid;
import com.eleven.model.User;
import com.eleven.service.ProfileService;
import com.eleven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by User on 2017/11/2.
 */
@Controller
public class HelloController {


    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        model.addAttribute("user",getPrincipal());
        return "welcome";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/dba", method = RequestMethod.GET)
    public String dbaPage(ModelMap model) {
        model.addAttribute("user",getPrincipal());
        return "dba";
    }

    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String AccessDeniedPage(ModelMap model){
        model.addAttribute("user",getPrincipal());
        return "accessDenied";
    }


    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String  logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(ModelMap model, @Validated User user, BindingResult result) {
       if (result.hasErrors()){
           System.out.println("There are errors");
           return "register";
       }
        userService.save(user);
        model.addAttribute("success", "User "
                + user.getFirstName() + " has been registered successfully");
        return "registrerSuccess";
    }

    @ModelAttribute("roles")
    public List<Profileid> initProfile(){
            return  profileService.findAll();
    }




    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.GET)
    public String registerPage(@PathVariable int id, ModelMap model) {
        User users = userService.findById(id);
        model.addAttribute("user", users);
        model.addAttribute("edit", true);
        return "edit";
    }


    @RequestMapping(value = {"/edit-user-{id}"}, method = RequestMethod.POST)
    public String register(@PathVariable int id, ModelMap model,User user) {
        userService.update(user);
        model.addAttribute("success", "User" + user.getLastName() + " update Success !!!");
        return "success";
    }

    @RequestMapping(value = {"/delete-user-{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable int id, ModelMap model) {
        User user = userService.findById(id);
        userService.delete(user);
        model.addAttribute("success", "User" + user.getLastName() + " Delete Success !!!");
        return "success";
    }



    /**
     *  通过Authentication.getPrincipal()可以获取到代表当前用户的信息，
     *  这个对象通常是UserDetails的实例。获取当前用户的用户名是一种比较常见的需求，
     *  关于上述代码其实Spring Security在Authentication中的实现类中已经为我们做了相关实现，
     *  所以获取当前用户的用户名最简单的方式应当如下。
     *  public String getCurrentUsername() {
     *  return SecurityContextHolder.getContext().getAuthentication().getName();
     *  }
     * @return
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
