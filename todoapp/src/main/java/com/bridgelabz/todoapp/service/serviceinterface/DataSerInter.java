package com.bridgelabz.todoapp.service.serviceinterface;

import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

/**
 * @author bridgelabz3 Raghava
 * this is DataSerInter interface
 */
public interface DataSerInter {

	public boolean addTitle(ToDoData toDoData);
	public List<ToDoData> dataList(int id);
	public boolean noteUpdate(ToDoData toDoData); 

}
