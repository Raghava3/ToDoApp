package com.bridgelabz.todoapp.service.serviceinterface;

import com.bridgelabz.todoapp.model.User;

//This is user service interface

public interface UserSerInter {

public boolean registration(User user);

public User login(String mail, String password);


}
