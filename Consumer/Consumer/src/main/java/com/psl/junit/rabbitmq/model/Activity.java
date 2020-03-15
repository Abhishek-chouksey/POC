package com.psl.junit.rabbitmq.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity
public class Activity {
	
	@Id
	private String activity;
	@Column
	private int count;
	public Activity() {
		
		// TODO Auto-generated constructor stub
	}
	public Activity(String activity, int count) {
		super();
		this.activity = activity;
		this.count = count;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void incrimentCount()
	{
		this.count++;
	}
	
	public void decrimentCount()
	{
		this.count--;
	}

}
