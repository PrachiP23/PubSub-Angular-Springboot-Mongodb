package com.javasampleapproach.springrest.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.javasampleapproach.springrest.mongodb.model.Subscriber;

public interface SubscriberRepository extends MongoRepository<Subscriber, String> {
	
	public List<Subscriber> findBySubName(String subName); 
	
	@Query("{'topicArr': ?0}")
	public List<Subscriber> findByTopic(String topic);
}
