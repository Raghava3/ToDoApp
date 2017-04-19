package com.bridgelabz.todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.todoapp.model.User;
import com.bridgelabz.todoapp.service.serviceinterface.UserSerInter;
import com.bridgelabz.todoapp.validator.RegValidation;

/**
 * @author bridgelabz3 Raghava
 * This RegistrationController class for user registration  
 * it registration method and returns ResponseEntity Object
 * import java.util.regex.Matcher;
 */
@RestController
public class RegController
{

	@Autowired
	private UserSerInter userSerInter;
	@Autowired
	private RegValidation regValidation;
	
 

	@RequestMapping(value="/signUp", method=RequestMethod.POST)
	public ResponseEntity<String> signUp(@RequestBody User user,BindingResult bindingResult, HttpServletRequest req,HttpServletResponse resp)
	{
		regValidation.validate(user, bindingResult);
		
		if(bindingResult.hasErrors())
		{
			return new ResponseEntity<String>("errors in requried field",HttpStatus.NOT_ACCEPTABLE);
		}
		else
		{
		 boolean  result=userSerInter.registration(user);
		
		 if(result)
		 {
			 return new ResponseEntity<String>("{status:'success', 'message':'Data saved!'}", HttpStatus.OK);
		 }
		 else
		 {
			 return new ResponseEntity<String>("{status:'failure !', 'message':'Data not  saved!'}",HttpStatus.NOT_ACCEPTABLE);
		 }
	
		}
}
}
