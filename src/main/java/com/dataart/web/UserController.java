package com.dataart.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.domain.Service;
import com.dataart.domain.User;
import com.dataart.enums.TransactionsTypeEnum;
import com.dataart.service.AccountService;
import com.dataart.service.Services;
import com.dataart.service.TransactionService;
import com.dataart.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionService transactionService;
    
    @Autowired
    private Services services;
    
    @Autowired
    private AccountService accountService;
    
    private User currentUser;
    
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
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
    
    
    
    public User getCurrentUser() {
    	if(currentUser == null){
    		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            currentUser = userService.getLoginUser(userName);
    	}
		return currentUser;
	}

	@RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }
    
    @RequestMapping("/Profile")
    public String UserProfile(Map<String, Object> map) {
    	Object object = SecurityContextHolder.getContext().getAuthentication().getDetails();
    	System.out.println("OBJECT " + object);
        /*map.put("user", new User());*/
        /* map.put("userProfile", userService.getProfile(User.getId()));*/
        return "user";
    }
    
    @RequestMapping("/ListUsers")
    public String listUsers(Map<String, Object> map) {

        map.put("user", new User());
        map.put("userList", userService.listUsers());
        return "user";
    }

    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user,
            BindingResult result) {
    	userService.addUser(user);
        return "redirect:/ListUsers";
    }

    @RequestMapping("/DeleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
    	userService.removeUser(userId);
        return "redirect:/ListUsers";
    }
    
    @RequestMapping(value = "/decreaseBalanceService", method = RequestMethod.POST)
    public String addTransaction(@ModelAttribute("money") Double money) {
    	if(currentUser.getAccount().getBalance() >= money){
    		accountService.decreaseBalance(currentUser.getAccount(), money);
    		transactionService.saveTransactionWithType(TransactionsTypeEnum.SERVICE_PAYMENT.toString(), money, currentUser.getAccount());
    	}
        return "redirect:/index";
    }
}