package com.bridgelabz.todoapp.dao.daoimplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.todoapp.dao.daointerface.DataDaoInter;
import com.bridgelabz.todoapp.model.ToDoData;


/**
 * @author bridgelabz3 Raghava
 * this class implements DataDaoInter and provide the implementation for methods 
 * addTitle method returns boolean 
 * dataList method returns List
 */
public class DataDaoImpl implements DataDaoInter
{

	@Autowired
	private SessionFactory sessionFactory;
	
	Session session;
	Transaction transaction;
	// This is method for user registration
	public boolean addTitle(ToDoData toDoData)

	{
		 session = sessionFactory.openSession();
		 transaction = session.beginTransaction();
		try {
			session.save(toDoData);
			transaction.commit();
			session.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	
	@Override
	public List<ToDoData> dataList(int id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		System.out.println("coming1");
	try{	
		String hql="from ToDoData where USER_ID=:id";
		Query query =session.createQuery(hql);
		query.setParameter("id",id);
		List<ToDoData> listofdata=query.list();
		transaction.commit();
		return listofdata;
	  }
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally {
		if(session!=null)
		{
			session.close();
		}
   	}
  }


	@Override
	public boolean noteUpdate(ToDoData toDoData) 
	{
	try{
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(toDoData);
		transaction.commit();
		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return false;
	}
	finally
	{
		if(session!=null)
		{
			session.close();
		}
	}
	}


	@Override
	public boolean noteToDelete(ToDoData toDoData) {
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.delete(toDoData);
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(session!=null)
			{
				session.close();
			}
		}
	}
	
	
	
}
