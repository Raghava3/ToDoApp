package com.bridgelabz.todoapp.service.serviceinterface;

import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

/**
 * @author bridgelabz3 Raghava this is DataSerInter interface
 */
public interface DataSerInter {

	/**
	 * 
	 * @param toDoData
	 * @return true/false
	 */
	public boolean addNote(ToDoData toDoData);

	public List<ToDoData> listOfNotes(int id);

	public boolean noteUpdate(ToDoData toDoData);

	public boolean noteToDelete(int id);

}
