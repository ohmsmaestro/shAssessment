package com.api.publishingserver.service;

import com.api.publishingserver.utils.TopicUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PublishService {
    public void publishMessage(String topic) {
        Map<String, Object> responseBody = new HashMap<>();
        Map<String, String> message = new HashMap<>();
        message.put("name", "Omenesa Muhammed");
        message.put("address", "Abuja");
        responseBody.put("topic", topic);
        responseBody.put("data", message);
        if (TopicUtil.topicsStorage.containsKey(topic)) {
            ArrayList<String> subscribers = TopicUtil.topicsStorage.get(topic);
            subscribers.forEach((subscriber) -> {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.add("Content-Type", "application/json;charset=utf-8");
                HttpEntity<String> httpEntity = new HttpEntity<>(responseBody.toString(), headers);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<Void> result = restTemplate.postForEntity(subscriber, responseBody, Void.class);
                if (result.getStatusCode() == HttpStatus.OK) {
                    System.out.println("successful");
                } else {
                    System.out.println("Failed");
                }
            });
        }
    }
}
