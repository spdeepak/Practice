package com.deepak.springboot.topic;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Deepak
 *
 */
public interface TopicDao extends CrudRepository<Topic, String> {

}
