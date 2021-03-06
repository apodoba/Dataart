package com.dataart.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dataart.domain.Service;
import com.dataart.service.AccountService;
import com.dataart.service.Services;
import com.dataart.service.TransactionService;
import com.dataart.service.UserService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
	
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private Services services;
    
	@Autowired
	private TransactionService transactionService;
          
    @RequestMapping("/account")
    public String pagePayForAccount(Map<String, Object> map) {
    	map.put("payAccount", true);
        return "user";
    }
    
    @RequestMapping("/service")
    public String pagePayForService(Map<String, Object> map) {
		List<Service> allServices = services.getServices();
		map.put("services", allServices);
		if (allServices != null && !allServices.isEmpty()) {
			map.put("selectedService", allServices.get(0));
		}
        return "user";
    }
    
    @RequestMapping("/increase")
    public String pagePutMoneyForAccoount(Map<String, Object> map) {
		map.put("increaseAccount", true);
        return "user";
    }

}
