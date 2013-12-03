package com.dataart.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataart.domain.User;
import com.dataart.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    private User currentUser;
   	
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }    
    
    @RequestMapping("/index")
    public String listServices(Map<String, Object> map) {
        currentUser = userService.getLoginUser();
        map.put("userProfile", currentUser);
        if(currentUser.getAccount()!=null){
        	map.put("userAccount", currentUser.getAccount());
        }
        return "user";
    }
    
    //TODO for admin only
    @RequestMapping("/ListUsers")
    public String listUsers(Map<String, Object> map) {
        map.put("user", new User());
        map.put("userList", userService.listUsers());
        return "user";
    }
}