package com.bridgelabz.todoapp.service.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.todoapp.dao.daointerface.UserDaoInter;
import com.bridgelabz.todoapp.model.User;
import com.bridgelabz.todoapp.service.serviceinterface.UserSerInter;

public class UserSerImpl implements UserSerInter 
{

	@Autowired
	private UserDaoInter userDaoInter;
	
	public boolean registration(User user) {
		return  userDaoInter.registration(user);
	}


	public User login(String mail, String password) {
		return userDaoInter.login(mail, password);
	}

	
}
