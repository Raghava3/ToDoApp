package com.bridgelabz.todoapp.dao.daointerface;

import com.bridgelabz.todoapp.model.User;

/**
 * @author bridgelabz3 Raghava
 * this is UserDaoInter interface
 *
 */
public interface UserDaoInter 
{
	public boolean registration(User user);
	public User login(String mail, String password);

}
