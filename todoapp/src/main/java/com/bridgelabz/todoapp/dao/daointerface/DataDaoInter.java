package com.bridgelabz.todoapp.dao.daointerface;

import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

/**
 * @author bridgelabz3 Raghava this is DataDaoInter interface
 *
 */
public interface DataDaoInter {
	/**
	 * add the note to data base
	 * @param toDoData
	 * @return boolean
	 */
	public boolean addNote(ToDoData toDoData);

	/**
	 * list of notes will be displayed based on user id
	 * @param id
	 * @return List<ToDoData>
	 */
	public List<ToDoData> listOfNotes(int id);

	/**
	 * note is going to be updated 
	 * @param toDoData
	 * @return boolean
	 */
	public boolean noteUpdate(ToDoData toDoData);

	/**
	 * note is going to be deleted based based on id
	 * @param id
	 * @return boolean
	 */
	public boolean noteToDelete(int id);
}
