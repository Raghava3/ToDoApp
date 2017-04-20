package com.bridgelabz.todoapp.service.serviceinterface;

import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

/**
 * @author bridgelabz3 Raghava this is DataSerInter interface
 */
public interface DataSerInter {

	/**
	 * @param toDoData
	 * @return true/false
	 */
	public boolean addNote(ToDoData toDoData);

	/**
	 * @param id
	 * @return List<ToDoData>
	 */
	public List<ToDoData> listOfNotes(int id);

	/**
	 * @param toDoData
	 * @return boolean
	 */
	public boolean noteUpdate(ToDoData toDoData);

	/**
	 * @param id
	 * @return boolean
	 */
	public boolean noteToDelete(int id);

}
