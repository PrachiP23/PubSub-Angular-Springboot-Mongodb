package com.javasampleapproach.springrest.mongodb.controller.Service;

import org.springframework.stereotype.Component;

@Component
public class PublisherService {
	
	public String retrieveWelcomeMessage() {
		return "Good Morning everyone!!!";
	}
}
