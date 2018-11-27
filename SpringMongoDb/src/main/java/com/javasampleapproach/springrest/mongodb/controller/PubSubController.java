package com.javasampleapproach.springrest.mongodb.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.javasampleapproach.springrest.mongodb.model.PubMessage;
import com.javasampleapproach.springrest.mongodb.model.Subscriber;
import com.javasampleapproach.springrest.mongodb.model.TopicContent;

import com.javasampleapproach.springrest.mongodb.repo.PublisherRepository;
import com.javasampleapproach.springrest.mongodb.repo.SubscriberRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PubSubController {
	
	@Autowired
	PublisherRepository pubRepo;
	
	@Autowired
	SubscriberRepository subRepo;
	
	@RequestMapping("/publish")
	public String publish(@RequestBody PubMessage pubMsg) {		
		List<TopicContent> topCont = pubMsg.getTopCont();
		PubMessage _pubMsg = null;
		List<PubMessage> pubMsgFromDB = pubRepo.findByPubName(pubMsg.getPubName());
		if((!pubMsgFromDB.isEmpty())) {
			  List<TopicContent> topCont1 = pubMsgFromDB.get(0).getTopCont();
			  topCont1.add(topCont.get(0));
			  pubMsgFromDB.get(0).setTopCont(topCont1);
			 _pubMsg = pubRepo.save(pubMsgFromDB.get(0));
		}else {
			_pubMsg = pubRepo.save(new PubMessage(pubMsg.getPubName(), topCont));
		}

		String topic = topCont.get(0).getTopic();
		List<Subscriber> allSubs = subRepo.findByTopic(topic);
		
		for (Subscriber sub : allSubs) {
			List<String> content = new ArrayList<>(); 
			if(sub.getContent()!=null) {
				content = sub.getContent();
			}
			content.add(topCont.get(0).getContent());
			sub.setContent(content);
			subRepo.save(sub);
		}
 
		return _pubMsg.toString();		
	}
	
	
	
	
	@RequestMapping("/subscribe")
	public String subscribeTopic(@RequestBody Subscriber sub) {
		Subscriber _subMsg = null;
		List<String> topic = sub.getTopicArr();
		List<Subscriber> subFromDB = subRepo.findBySubName(sub.getSubName());
		if((!subFromDB.isEmpty())) {
			List<String> topic1 = subFromDB.get(0).getTopicArr();
			topic1.add(topic.get(0));
			subFromDB.get(0).setTopicArr(topic1);
			_subMsg = subRepo.save(subFromDB.get(0));
		}else {
			 _subMsg = subRepo.save(new Subscriber(sub.getSubName(), topic, sub.getContent()));
		}
		
		return _subMsg.toString();
	}

	@RequestMapping("/allPubs")
	public List<PubMessage> getAllPublishers() {
		List<PubMessage> allPubs = new ArrayList<>();
		pubRepo.findAll().forEach(allPubs::add);
		return allPubs;
	}
	
	@RequestMapping("/allSubs")
	public List<Subscriber> getAllSubscribers() {
		List<Subscriber> allSubs = new ArrayList<>();
		subRepo.findAll().forEach(allSubs::add);
		return allSubs;
	}
}
