package com.bridgelabz.todoapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.todoapp.model.User;
import com.bridgelabz.todoapp.service.serviceinterface.UserSerInter;

/**
 * @author bridgelabz3 Raghava
 * This LoginController class for Login validation  based on the email and password 
 * given by the user, and  it calls login method and returns ResponseEntity Object
 * 
 */

@RestController
public class LoginController {

	@Autowired
	UserSerInter userSerInter;

	/*
	 *  this method is to login validation 
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Map<String, String> loginMap, HttpServletRequest request,
			HttpServletResponse response) 
	{
		User user = userSerInter.login(loginMap.get("email"), loginMap.get("password"));//taking user id and password
		if (user != null)
		{
			
			HttpSession session=request.getSession();//if login sucessfull then setting the session 
			session.setAttribute("user",user);       //setting session 
			return new ResponseEntity<String>("{status:'sucess',message='Login sucessfull'}", HttpStatus.ACCEPTED);
		} 
		else 
		{
			return new ResponseEntity<String>("{status:'failure',message='invalid creadentials'}",
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
