package com.api.subscribingserver_two.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SubscriberService {
    public void receiveMessage(Map<String, Object> message) {
        if(message.containsKey("data")){
            System.out.println(message.get("date"));
        }
    }
}
