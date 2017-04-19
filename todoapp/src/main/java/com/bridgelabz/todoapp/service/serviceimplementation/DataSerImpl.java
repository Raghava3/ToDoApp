package com.bridgelabz.todoapp.service.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.todoapp.dao.daointerface.DataDaoInter;
import com.bridgelabz.todoapp.model.ToDoData;
import com.bridgelabz.todoapp.service.serviceinterface.DataSerInter;

public class DataSerImpl implements DataSerInter 
{
	@Autowired
	DataDaoInter dataDaoInter;
	
	public boolean addTitle(ToDoData toDoData)
	{
	  return dataDaoInter.addTitle(toDoData);
	}

	@Override
	public List<ToDoData> dataList(int id)
	{
		return dataDaoInter.dataList(id);
	}

}
