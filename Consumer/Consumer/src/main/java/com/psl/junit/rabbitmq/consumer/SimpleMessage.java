package com.psl.junit.rabbitmq.consumer;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

    private int id;
    private String description;

    public SimpleMessage() {
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SimpleMessage [id=" + id + ", description=" + description + "]";
	}

   
   
}