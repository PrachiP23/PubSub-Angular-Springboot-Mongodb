package com.javasampleapproach.springrest.mongodb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javasampleapproach.springrest.mongodb.model.PubMessage;

public interface PublisherRepository extends MongoRepository<PubMessage, String> {
	public List<PubMessage> findByPubName(String pubName);

}
