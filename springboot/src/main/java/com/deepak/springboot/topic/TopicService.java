package com.deepak.springboot.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Deepak
 *
 */
@Service
public class TopicService {

    @Autowired
    private TopicDao topicDao;

    private List<Topic> topics = new ArrayList() {

        {
            add(new Topic("java", "Core Java", "Core Java Description"));
            add(new Topic("spring", "Spring", "Spring Framework Description"));
            add(new Topic("hibernate", "Hibernate ORM", "Hibernate ORM Description"));
            add(new Topic("js", "Javascript", "Javascript Description"));
        }
    };

    public List<Topic> getAllTopics() {
        //        return topics;
        List<Topic> topics = new ArrayList();
        topicDao.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopicById(String id) {
        //        return topics.stream()
        //                     .filter(e -> e.getId()
        //                                   .equals(id))
        //                     .findFirst()
        //                     .get();
        return topicDao.findOne(id);
    }

    public void createTopic(Topic topic) {
        //        topics.add(topic);
        topicDao.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId()
                 .equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId()
                              .equals(id));
    }

}
