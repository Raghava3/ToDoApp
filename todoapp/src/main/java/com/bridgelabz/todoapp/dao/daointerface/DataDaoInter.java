package com.bridgelabz.todoapp.dao.daointerface;


import java.util.List;

import com.bridgelabz.todoapp.model.ToDoData;

/**
 * @author bridgelabz3 Raghava
 * this is DataDaoInter interface
 *
 */
public interface DataDaoInter
{
	public boolean addTitle(ToDoData toDoData);
	public List<ToDoData> dataList(int id);
    public boolean noteUpdate(ToDoData toDoData);
    public boolean noteToDelete(ToDoData toDoData);
}
