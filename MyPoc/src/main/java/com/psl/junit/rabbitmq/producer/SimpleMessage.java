package com.psl.junit.rabbitmq.producer;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class SimpleMessage implements Serializable {

	 private Long id;
	    private String description;

	    public SimpleMessage() {
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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