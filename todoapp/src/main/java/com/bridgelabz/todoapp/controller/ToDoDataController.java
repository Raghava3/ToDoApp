package com.bridgelabz.todoapp.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.todoapp.model.ToDoData;
import com.bridgelabz.todoapp.model.User;
import com.bridgelabz.todoapp.service.serviceinterface.DataSerInter;


/**
 * @author bridgelabz3 Raghava data controller class adding in to the mysql
 *         database getting the session from the login controller and setting
 *         the user id in the tododata table
 */
@RestController
public class ToDoDataController {

	@Autowired
	DataSerInter dataSerInter;

/*	this method is add note in to the database
*/	
	
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody ToDoData toDoData, HttpServletRequest req,
			HttpServletResponse resp) 
	{

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");	// getting the user object from the login contorller
	
		if ( user != null)                                 //if session is null then it will print unauthorized
		{
			toDoData.setUser(user);                       // setting the user object so user_id in the data table will automatically added
			boolean result = dataSerInter.addTitle(toDoData);
			if (result) {
				return new ResponseEntity<String>("sucess", HttpStatus.ACCEPTED);
			} 
			 else {
				return new ResponseEntity<String>("not sucess", HttpStatus.METHOD_NOT_ALLOWED);
			 }
		} 
		
		else {
			return new ResponseEntity<String>("status : failure ", HttpStatus.UNAUTHORIZED);
		}

	}
	
	
	
/*	this method is to get the list of notes for particular user
*/
	
	@RequestMapping(value="dataList" , method=RequestMethod.GET)
    public ResponseEntity<String> dataList( HttpServletRequest req, HttpServletResponse resp)
	{
	
	HttpSession session=req.getSession();
	User user = (User) session.getAttribute("user");
	if(user!=null) //checking that user is logged in or not 
	{
		int id=user.getId();
		List<ToDoData>	listofdata =dataSerInter.dataList(id);//calling the dataList method 
	    Iterator<ToDoData> iterator=listofdata.iterator();  //iterating
	  while(iterator.hasNext())
	 {
		ToDoData datafromiterator=(ToDoData) iterator.next();
		System.out.println("Note id    "+datafromiterator.getId());
		System.out.println("Title      "+datafromiterator.getTitle());
		System.out.println("Description"+datafromiterator.getDescription());
		System.out.println("Reminder   "+datafromiterator.getReminder());
        System.out.println("Updated    "+datafromiterator.getUpdated());
	 }
	
	  return new  ResponseEntity<String>("data retrived",HttpStatus.OK);
	}
	else{
	return new  ResponseEntity<String>("data not retrived",HttpStatus.UNAUTHORIZED);
    }
  }
	
	/*
	 *  this is updateNote method 
	 */
	
	@RequestMapping(value="updateNote/{id}",method=RequestMethod.POST)//takes DATA_ID to update that is updateId
	public ResponseEntity<String>updateNote(@RequestBody ToDoData toDoData,@PathVariable("id")int updateId,HttpServletRequest 
			req, HttpServletResponse resp)
	{
	
		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("user");
		if(user!=null)                                           //checking that user is logged in or not 
		{
			int id=user.getId();                                  //getting the user id who is login 
			List<ToDoData>	listofdata =dataSerInter.dataList(id);//calling the dataList method   based on id
		    Iterator<ToDoData> iterator=listofdata.iterator();  //iterating
		  while(iterator.hasNext())
		 {
			ToDoData datafromiterator=(ToDoData) iterator.next();
		if(datafromiterator.getId()==updateId)//checking that passed id is existed in the To_Do_Data table
		{
			toDoData.setUser(user); // setting the same user id who is login
			toDoData.setId(updateId);//DATA_ID should be same so setting the id 
			if(	dataSerInter.noteUpdate(toDoData)){
				return new ResponseEntity<String>("status:'sucess',message:'updated'",HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>("status:'failure',message:'data id is not matching'",HttpStatus.BAD_REQUEST);
			}
	     }
	    }
				return new ResponseEntity<String>("not valid id",HttpStatus.BAD_REQUEST);
	 }
			return new ResponseEntity<String>("not login",HttpStatus.NOT_ACCEPTABLE);
	}
}
