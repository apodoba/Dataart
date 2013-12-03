package com.dataart.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dataart.domain.Service;
import com.dataart.domain.User;
import com.dataart.service.Services;
import com.dataart.service.UserService;

@Controller
public class DefaultController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private Services services;
    
	private User currentUser;
	

	
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }    
    
    @RequestMapping("/index")
    public String listServices(Map<String, Object> map) {
    	String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        map.put("user", new User());
        currentUser = userService.getLoginUser(userName);
        map.put("userProfile", currentUser);
        if(currentUser.getAccount()!=null){
        	map.put("userAccount", currentUser.getAccount());
        }
        List<Service> allServices = services.getServices();
        map.put("services", allServices);
        if(allServices != null && !allServices.isEmpty()){
        	map.put("selectedService", allServices.get(0));
        }
        return "user";
    }
    
    
} 