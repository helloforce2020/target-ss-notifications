package com.target.notification.utils;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * This is a wrapper class for Kafka streams. This utility pushes data to the streams.
 * 
 * @author vinaymajety
 *
 */
@Component
public class NotificationEventsProducer {


  /**
   * publishes the message to the given topic.
   * 
   * @param topic topic of the queue
   * @param message message to publish
   */
  public void pushToStream(String topic, Map<String, Object> message) {
    /*
     * if (producer == null) 
     *  { 
     *    producer = new Producer<>(); 
     *  } 
     *  sendMessageToTopic(topic, message); }
     */
  }
}