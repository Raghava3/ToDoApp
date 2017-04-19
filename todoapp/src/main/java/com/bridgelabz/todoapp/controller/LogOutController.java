package com.bridgelabz.todoapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutController {

	@RequestMapping(value="/logOut",method=RequestMethod.POST)
	public ResponseEntity<String> logOut(HttpServletResponse resp, HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		if(session.getAttribute("user")!=null)
		{
			session.invalidate();
			return new ResponseEntity<String>("log out sucess ",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("please login first  ",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}
