package com.deepak.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Deepak
 *
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(path = "/topics", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(path = "/topic/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Topic getTopicById(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topic/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

}