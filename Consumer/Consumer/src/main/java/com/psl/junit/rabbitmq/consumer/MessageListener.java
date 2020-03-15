package com.psl.junit.rabbitmq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.junit.rabbitmq.dao.ConsumerDao;

@Component
public class MessageListener {
	
	@Autowired
	ConsumerDao dao; 
	
	public void recieveMessage(String message) {
		
		
		System.out.println("message is "+message);
		
		if(message.contentEquals("getAllItems")) {
			dao.getAllCount();
		}
		
		if(message.contentEquals("getItemById")) {
			dao.getItemByIdCount();;
		}
		
		if(message.contentEquals("saveItem")) {
			dao.saveItemCount();
		}
		
		if(message.contentEquals("removeItem")) {
			dao.deleteItemCount();
		}
		
			System.out.println("message is Received: " + message);
		
		

	}
}
