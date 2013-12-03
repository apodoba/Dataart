package com.dataart.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataart.domain.User;
import com.dataart.enums.TransactionsTypeEnum;
import com.dataart.service.AccountService;
import com.dataart.service.TransactionService;
import com.dataart.service.UserService;

@Controller
public class AccountController {
	
    @Autowired
    private AccountService accountService;
    
	@Autowired
	private TransactionService transactionService;
    
    private User currentUser;
    
    @RequestMapping(value = "/moveBalance/Service", method = RequestMethod.POST)
    public String moveBlToServ(@ModelAttribute("money") Double money) {
    	if(currentUser.getAccount().getBalance() >= money){
    		accountService.decreaseBalance(currentUser.getAccount(), money);
    		transactionService.saveTransactionWithType(TransactionsTypeEnum.SERVICE_PAYMENT.toString(), money, currentUser.getAccount());
    	}
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/moveBalance/Human", method = RequestMethod.POST)
    public String moveBlToHuman(@ModelAttribute("acc") String accountName, @ModelAttribute("money") Double money) {
    	if(currentUser.getAccount().getBalance() >= money){
    		accountService.increaseBalance(accountService.getAccount(accountName), money);
    		accountService.decreaseBalance(currentUser.getAccount(), money);
    		transactionService.saveTransactionWithType(TransactionsTypeEnum.HUMAN_PAYMENT.toString(), money, currentUser.getAccount());
    	}
        return "redirect:/index";
    }

}