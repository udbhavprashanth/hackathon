package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	// Mutable arraylist
	List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring FrameWork", "Spring FrameWork description"),
			new Topic("Java","Java FrameWork", "Java description"),
			new Topic("Nodejs","Nodejs FrameWork", "Nodejs description")
			
			));
	
	public List<Topic> getAllTopic() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		//lambda expression
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
	 topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size();i++) {
			Topic t=topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return; 
			}
		}
		
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
		
	}

}
