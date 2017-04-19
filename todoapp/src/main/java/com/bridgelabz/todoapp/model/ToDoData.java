package com.bridgelabz.todoapp.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="To_Do_Data")
public class ToDoData  
{
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="DATA_ID")
	private int id;
	@Column(name="TITLE")
	private String title;
	@Column(name="DESCRIPTION")
	private String description;
    @Column(name="REMINDER")
	private Date reminder;
    @Column(name="UPDATED_DATE")
    private Date updated=new Date();

    @ManyToOne(cascade=CascadeType.DETACH)
  //  @JoinColumn(name="USER_ID")
    private User user;
    
    
    
   public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReminder() {
		return reminder;
	}
	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}
	public Date getUpdated() {
		return updated;
	}
}
