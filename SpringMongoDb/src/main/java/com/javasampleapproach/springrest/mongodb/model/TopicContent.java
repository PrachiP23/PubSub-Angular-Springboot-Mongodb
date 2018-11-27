package com.javasampleapproach.springrest.mongodb.model;

import org.springframework.data.annotation.Id;

public class TopicContent {

	private String topic;
	private String content;

	public TopicContent() {
		
	}
	
	public TopicContent( String topic, String content) {
		
		this.topic = topic;
		this.content = content;
	}


	public String getTopic() {
		return topic;
	}
	
	public String getContent() {
		return content;
	}
	

	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
