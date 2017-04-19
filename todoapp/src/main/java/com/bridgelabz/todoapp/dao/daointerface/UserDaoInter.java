package com.bridgelabz.todoapp.dao.daointerface;

import com.bridgelabz.todoapp.model.User;

public interface UserDaoInter 
{
	public boolean registration(User user);
	public User login(String mail, String password);

}
