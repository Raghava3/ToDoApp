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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author bridgelabz3 Raghava data controller class adding in to the mysql
 *         database getting the session from the login controller and setting
 *         the user id in the tododata table
 */
@RestController
public class ToDoDataController {

	@Autowired
	DataSerInter dataSerInter;
	
	/**
	 *  first check if logged in or not if logged in then add note. or send failure status
	 * @param toDoData
	 * @param req
	 * @param resp
	 * @return ResponseEntity
	 * @throws JsonProcessingException 
	 *    
	 */
	@RequestMapping(value = "addNote", method = RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody ToDoData toDoData, HttpServletRequest req,
			HttpServletResponse resp) throws JsonProcessingException {

		System.out.println("coming inside the add method");
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");//getting the user object from the login contorller
		if (user != null)                               // if session is null then it will print unauthorized
		{
			toDoData.setUser(user);                     // setting the user object so user_id in the
			boolean result = dataSerInter.addNote(toDoData);
			if (result) {
				ObjectMapper mapper=new ObjectMapper();
				ObjectNode root=mapper.createObjectNode();
				root.put("status", "sucess");
				root.putPOJO("todo", toDoData);
				String data=mapper.writeValueAsString(root);
				return new ResponseEntity<String>(data, HttpStatus.OK);} 
			else {
				
				ObjectMapper  mapper=new ObjectMapper();
				ObjectNode root=mapper.createObjectNode();
				root.put("status", "failure");
				String data=mapper.writeValueAsString(root);
				return new ResponseEntity<String>(data, HttpStatus.METHOD_NOT_ALLOWED);}
		}
		else {
			
			ObjectMapper mapper=new ObjectMapper();
			ObjectNode root=mapper.createObjectNode();
			root.put("status", "failure");
			String data=mapper.writeValueAsString(root);
			return new ResponseEntity<String>(data, HttpStatus.UNAUTHORIZED);}
	}
///////////////////////////////end of method///////////////////////////////////////////////////////////////////////////// 

	
	@SuppressWarnings("deprecation")
	/**
	 * first check if logged in or not if logged in then show notes added by logged in user. or send failure status 
	 * @param req
	 * @param resp
	 * @return string,HttpStatus
	 * @throws JsonProcessingException 
	 *   
	 */
	@RequestMapping(value = "listOfNotes", method = RequestMethod.GET)
	public ResponseEntity<String> dataList(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null)                                             // checking that user is logged in or not
		{
			System.out.println("coming");
			int id = user.getId();
			List<ToDoData> listofdata = dataSerInter.listOfNotes(id);// calling the dataList method
/*			Iterator<ToDoData> iterator = listofdata.iterator();     // iterating
*/			
			ObjectMapper mapper=new ObjectMapper();
			JsonNode node = mapper.valueToTree(listofdata);
			//System.out.println("node"+node.toString());
			ObjectNode root=mapper.createObjectNode();
			  root.put("listofnotes",node);
			 System.out.println("inside listofnotes");
			  String data=mapper.writeValueAsString(root);
			 // System.out.println("data"+listofdata.toString());
			return new ResponseEntity<String>(data, HttpStatus.OK);
		}
		else 
		{
			ObjectMapper mapper=new ObjectMapper();
			ObjectNode root=mapper.createObjectNode();
			  root.put("status", "failure");
	     String data=mapper.writeValueAsString(root);
			  return new ResponseEntity<String>(data, HttpStatus.UNAUTHORIZED);
		}
	}
///////////////////////////////end of method///////////////////////////////////////////////////////////////////////////// 
	
	

	/**
	 *  first check if logged in or not if logged in then update note based on id. or send failure status .
	 * @param toDoData
	 * @param updateId
	 * @param req
	 * @param resp
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "updateNote/{id}", method = RequestMethod.POST) 
	public ResponseEntity<String> updateNote(@RequestBody ToDoData toDoData, @PathVariable("id") int updateId,
			HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null)                                            // checking that user is logged in or not
		{
			int id = user.getId();                                   // getting the user id who is login
			List<ToDoData> listofdata = dataSerInter.listOfNotes(id);// calling the listOfNotes
			Iterator<ToDoData> iterator = listofdata.iterator();     // iterating
			while (iterator.hasNext()) {
				ToDoData datafromiterator = (ToDoData) iterator.next();
				if (datafromiterator.getId() == updateId)           // checking that passed id is existed in the To_Do_Data
				{
					toDoData.setUser(user);                        // setting the same user id who is login
					toDoData.setId(updateId);                      // DATA_ID should be same so
					if (dataSerInter.noteUpdate(toDoData))
					{
						return new ResponseEntity<String>("status:'sucess',message:'updated'", HttpStatus.OK);
					} else {
						return new ResponseEntity<String>("status:'failure',message:'data id is not matching'",
								HttpStatus.BAD_REQUEST);
					}
				}
			}
			return new ResponseEntity<String>("not valid id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("not login", HttpStatus.NOT_ACCEPTABLE);
	}
///////////////////////////////end of method///////////////////////////////////////////////////////////////////////////// 
	

	
	/**
	 *  first check if logged in or not if logged in then delete note based on id. or send failure status 
	 * @param updateId
	 * @param req
	 * @param resp
	 * @return ResponseEntity 
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value ="/noteToDelete/{id}", method = RequestMethod.GET) 
	public ResponseEntity<String> noteToDelete(@PathVariable("id") int updateId, HttpServletRequest req,
			HttpServletResponse resp) throws JsonProcessingException {
System.out.println("inside notetodelete");
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null)                                            // checking that user is logged in or not
		{
			
			boolean result = dataSerInter.noteToDelete(updateId);

			System.out.println("result"+result);
			if (result ) {
				
				List<ToDoData> todoList = dataSerInter.listOfNotes(user.getId());
				
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode root = mapper.createObjectNode();
				
				root.put("status", "success");
				root.putPOJO("todo", todoList);
				
				String data = mapper.writeValueAsString(root);
				System.out.println( data ); 
				System.out.println("line above the return ");
				return new ResponseEntity<String>(data, HttpStatus.OK);
				
			} else {
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode root = mapper.createObjectNode();
				
				root.put("status", "toDoNot there");
				String data = mapper.writeValueAsString(root);
				System.out.println( data ); 
				
				return new ResponseEntity<String>(data, HttpStatus.NOT_FOUND);
			}
		}
		else{
		
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode root = mapper.createObjectNode();
			
			root.put("status", "signIn first");
			String data = mapper.writeValueAsString(root);
			System.out.println( data );
		
		return new ResponseEntity<String>(data, HttpStatus.UNAUTHORIZED);
		
		}
	}
	
}		
			/*int id = user.getId();                                   // getting the user id who is login
			List<ToDoData> listofdata = dataSerInter.listOfNotes(id);// calling the dataList method based on id
			Iterator<ToDoData> iterator = listofdata.iterator();     // iterating
			while (iterator.hasNext()) {
				ToDoData datafromiterator = (ToDoData) iterator.next();
				if (datafromiterator.getId() == updateId)            // checking that passed id is existed in the To_Do_Data table
				{

					if (dataSerInter.noteToDelete(updateId)) {
						return new ResponseEntity<String>("status:'sucess',message:'deleted'", HttpStatus.OK);
					} else {
						return new ResponseEntity<String>("status:'failure',message:'data id is not matching'",
								HttpStatus.BAD_REQUEST);
					}
				}
			}
			return new ResponseEntity<String>("not valid id", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("not login", HttpStatus.NOT_ACCEPTABLE);
	}
}*/
/////////////////////////////end of method//////////////////////////////////////////////////////////////////