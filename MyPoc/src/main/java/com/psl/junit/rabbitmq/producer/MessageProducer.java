package com.psl.junit.rabbitmq.producer;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psl.junit.rabbitmq.config.RobbitMqConfig;


@Component
public class MessageProducer {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String m) {

		
		System.out.println("message to sent"+m);
		rabbitTemplate.convertAndSend(RobbitMqConfig.ROUTING_KEY, m);
	    System.out.println("Is listener returned ::: "+rabbitTemplate.isReturnListener());
	    
	}
}
