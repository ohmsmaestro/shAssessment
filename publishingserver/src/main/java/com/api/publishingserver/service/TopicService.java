package com.api.publishingserver.service;

import com.api.publishingserver.utils.TopicUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class TopicService {
    public Map<String, String> createTopic(String topic, String client){
        if(TopicUtil.topicsStorage.containsKey(topic)){
            ArrayList<String> subscribers = TopicUtil.topicsStorage.get(topic);
            if(!subscribers.contains(client)){
                subscribers.add(client);
            }
            TopicUtil.topicsStorage.put(topic, subscribers);
        }
        else{
            ArrayList<String> subscribers =  new ArrayList<>();
            subscribers.add(client);
            TopicUtil.topicsStorage.put(topic, subscribers);
        }

        Map<String, String> response = new HashMap<>();

        response.put("url", client);
        response.put("topic", topic);

        return response;
        //TopicUtil.topicsStorage.put()
    }
}
