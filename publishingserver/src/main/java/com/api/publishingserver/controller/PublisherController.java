package com.api.publishingserver.controller;

import com.api.publishingserver.service.PublishService;
import com.api.publishingserver.service.TopicService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PublisherController {
    private final TopicService topicService;
    private final PublishService publishService;

    public PublisherController(TopicService topicService, PublishService publishService) {
        this.topicService = topicService;
        this.publishService = publishService;
    }

    @PostMapping(value = "/subscribe/{topic}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> createSubscription(@PathVariable(value = "topic") String topic, @RequestBody Map<String, String> payload){

        return ResponseEntity.status(HttpStatus.OK).body(topicService.createTopic(topic, payload.get("url")));
    }

    @PostMapping(value = "/publish/{topic}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> publish(@PathVariable(value = "topic") String topic){
        publishService.publishMessage(topic);
        return ResponseEntity.ok().build();
    }
}
