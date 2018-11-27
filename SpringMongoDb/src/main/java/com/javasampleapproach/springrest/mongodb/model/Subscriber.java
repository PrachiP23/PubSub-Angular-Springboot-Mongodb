package com.javasampleapproach.springrest.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Subscriber {
	@Id
    public String id;
	
	private String subName;
	private List<String> topicArr;
	private List<String> content;

	public Subscriber() {
		
	}
	
	public Subscriber(String subName, List<String> topicArr, List<String> content) {
		this.subName = subName;
		this.topicArr = topicArr;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}

	public String getSubName() {
		return subName;
	}
	
	public List<String> getTopicArr() {
		return topicArr;
	}
	
	public List<String> getContent() {
		return content;
	}
	
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	public void setTopicArr(List<String> topicArr) {
		this.topicArr = topicArr;
	}
	
	public void setContent(List<String> content) {
		this.content = content;
	}
}
