package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	// Mutable arraylist
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring FrameWork", "Spring FrameWork description"),
			new Topic("Java","Java FrameWork", "Java description"),
			new Topic("Nodejs","Nodejs FrameWork", "Nodejs description")
			
			));
	
	public List<Topic> getAllTopic() {
		
		List<Topic> topics = new ArrayList<>();
		//lamda expression and method references
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
		
	}

}
