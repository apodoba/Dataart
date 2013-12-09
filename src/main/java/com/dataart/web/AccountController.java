package com.dataart.web;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.domain.Account;
import com.dataart.domain.ScratchCard;
import com.dataart.service.AccountService;
import com.dataart.service.ScratchCardService;
import com.dataart.service.TransactionService;
import com.dataart.service.UserService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private HttpServletRequest context;
    
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private ScratchCardService cardService;
	
    @RequestMapping(value = "/moveBalance/Service", method = RequestMethod.POST)
    public String moveBalanceToService(@ModelAttribute("money") Double money, @ModelAttribute("number") String number) {
    	int accountNumber;
    	try{
    		accountNumber = Integer.parseInt(number);
    	}catch (NumberFormatException e){
    		return "redirect:/payment/service?error=Wrong value of sum or account number";
    	}
    	if(userService.getLoginUser().getAccount().getBalance() >= money && money > 0 && accountNumber>0){
    		String description = context.getParameter("service") +" "+ number;
    		accountService.payForService(userService.getLoginUser(), money, description);
    	}else{
    		return "redirect:/payment/service?error=Wrong value of sum or account number";
    	}
        return "redirect:/payment/service?answer=You paid for "+context.getParameter("service");
    }
    
    @RequestMapping(value = "/moveBalance/Human", method = RequestMethod.POST)
    public String moveBlToHuman(@ModelAttribute("account") String accountName, @ModelAttribute("money") Double money) {
    	if(userService.getLoginUser().getAccount().getBalance() >= money && money > 0){
    		Account account = accountService.getAccount(accountName);
    		if(account == null) 
    			return "redirect:/payment/account?error=Account doesn't exist";
    		if(account.getId().intValue()==userService.getLoginUser().getAccount().getId())
    			return "redirect:/payment/account?error=It's your own account";
    		accountService.payForAccount(userService.getLoginUser(), money, account);
    	}else{
    		return "redirect:/payment/account?error=Wrong value of sum";
    	}
        return "redirect:/payment/account?answer=You paid for "+accountName + " account";
    }
    
    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    public String increaseAccount(@ModelAttribute("money") String money) {
         	if(money!=null){
        		ScratchCard card= cardService.getCardById(money);
        		if ((card != null  && (card.getEnable()) )) 
        			{
        	   		accountService.putMoneyForAccount(userService.getLoginUser(), card.getMoney());
        	   		cardService.disable(card);
        	   		return "redirect:/payment/increase?answer=Your account increased at "+card.getMoney();
        			}else return "redirect:/payment/increase?error=Scratch card with this number doesn't exist";
        		

    	}else{
    		return "redirect:/payment/increase?error=Wrong value of sum";
    	}
       
    }

    @RequestMapping(value = "/transactions")
    public String getTransactions(Map<String, Object> map) {
    	Account account = userService.getLoginUser().getAccount();
    	if(account != null){
    		map.put("transactions", accountService.getTransactions(account));
    	}else{
    		map.put("transactions", Collections.emptyList());
    	}
    	
        return "user";
    }
}