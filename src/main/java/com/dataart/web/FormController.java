package com.dataart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@SuppressWarnings("deprecation")
@Controller
public class FormController extends SimpleFormController{
	private Integer pid;
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, 
    		Object command, BindException errors) throws Exception{
    	String to2 = "redirect:"+getSuccessView();
    	request.getSession().setAttribute("pid",pid);
    	return new ModelAndView(to2);  
    	
    }
   
	@Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception{
    	/*pid=new pid();*/
    	pid=(Integer) request.getSession().getAttribute("pid");
    	return pid;
    }
}