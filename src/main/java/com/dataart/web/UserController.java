package com.dataart.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.domain.Account;
import com.dataart.domain.User;
import com.dataart.service.AccountService;
import com.dataart.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private HttpServletRequest context;
    
    private User currentUser;
   	
    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }    
    
    @RequestMapping("/index")
    public String listServices(Map<String, Object> map) {
    	map.put("admin", isAdmin());
        currentUser = userService.getLoginUser();
        map.put("userProfile", currentUser);
        if(currentUser.getAccount()!=null){
        	map.put("userAccount", currentUser.getAccount());
        }
        return "user";
    }
    
    @RequestMapping("/list/users")
    public String listUsers(Map<String, Object> map) {
    	List<User> allUsers = userService.listUsers();
        map.put("userList", allUsers);
        map.put("admin", isAdmin());
        if(!allUsers.isEmpty()){
        	map.put("selectedUser", allUsers.get(0));
        }
        return "user";
    }
    
    @RequestMapping(value="/users/transactions", method = RequestMethod.POST)
    public String getTransactionForUser(Map<String, Object> map) {
    	String name = context.getParameter("locale");
    	User user = userService.getUserByName((name));
    	List<User> allUsers = userService.listUsers();
        map.put("userList", allUsers);
        map.put("admin", isAdmin());
        if(!allUsers.isEmpty() && user!=null){
        	map.put("selectedUser", user);
        }
    	if(user != null){
    		Account account = user.getAccount();
    		if(account != null){
				map.put("transactionsUsers", accountService.getTransactions(account));
    		}
    	}
    	return "redirect:/list/users";
    }
    
    public boolean isAdmin(){
    	Object[] roles = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();
    	String role = roles[0].toString();
    	if("ROLE_ADMIN".equals(role)) return true;
    	return false;
    }
}