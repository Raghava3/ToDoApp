package com.bridgelabz.todoapp.service.serviceinterface;

import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

public interface DataSerInter {

	public boolean addTitle(ToDoData toDoData);
	public List<ToDoData> dataList(int id);
}
