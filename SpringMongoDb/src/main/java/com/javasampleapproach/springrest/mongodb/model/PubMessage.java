package com.javasampleapproach.springrest.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pubMessage")
public class PubMessage {
	@Id
    public String id;
	
	private String pubName;

	private List<TopicContent> topCont;

	public PubMessage() {
		
	}
	
	public PubMessage(String pubName, List<TopicContent> topCont) {
		this.pubName = pubName;
		this.topCont = topCont;
	}
	
	public String getId() {
		return id;
	}

	public String getPubName() {
		return pubName;
	}
	
	public List<TopicContent> getTopCont(){
		return topCont;
	}
	
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	
	public void setTopCont(List<TopicContent> topCont) {
		this.topCont = topCont;
	}

}
