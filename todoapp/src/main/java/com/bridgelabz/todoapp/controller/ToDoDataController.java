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

	//this method is add note in to the database
	@SuppressWarnings("unused")
	@RequestMapping(value = "/addNote", method = RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody ToDoData toDoData, HttpServletRequest req,
			HttpServletResponse resp) 
	{

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");	// getting the user object from the login contorller
		if ( session != null)   //if session is null then it will print unauthorized
		{
			// setting the user object
			// have to do logout to add new user
			toDoData.setUser(user);
			boolean result = dataSerInter.addTitle(toDoData);
			if (result) 
			{
				return new ResponseEntity<String>("sucess", HttpStatus.ACCEPTED);
			} 
			 else 
			 {
				return new ResponseEntity<String>("not sucess", HttpStatus.METHOD_NOT_ALLOWED);
			 }
		} 
		
		else 
		{
			return new ResponseEntity<String>("status : failure ", HttpStatus.UNAUTHORIZED);
		}

	}
	
	//this method is to get the list of notes for particular user
	@RequestMapping(value="dataList" , method=RequestMethod.GET)
    public ResponseEntity<String> dataList( HttpServletRequest req, HttpServletResponse resp)
	{
		
		
	
	HttpSession session=req.getSession();
	User user = (User) session.getAttribute("user");
	if(user!=null) //checking that user is logged in or not 
	{
		int id=user.getId();
		List<ToDoData>	listofdata =dataSerInter.dataList(id);
	  Iterator iterator=listofdata.iterator();
	  while(iterator.hasNext())
	 {
		ToDoData datafromiterator=(ToDoData) iterator.next();
		System.out.println(datafromiterator.getId());
		System.out.println(datafromiterator.getTitle());
		System.out.println(datafromiterator.getDescription());
		System.out.println(datafromiterator.getReminder());
        System.out.println(datafromiterator.getUpdated());
	 }
	
	  return new  ResponseEntity<String>("data retrived",HttpStatus.OK);
	
	}
	return new  ResponseEntity<String>("data retrived",HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
  }

	
	/*@RequestMapping(value="/updatedList/{id}",method=RequestMethod.POST)
	public ResponseEntity<String>updateList(@PathVariable("id")int id,HttpServletRequest req, HttpServletResponse resp)
	{
		
	}*/
}
