package com.bridgelabz.todoapp.dao.daointerface;


import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

public interface DataDaoInter
{
	public boolean addTitle(ToDoData toDoData);
	public List<ToDoData> dataList(int id);

}
