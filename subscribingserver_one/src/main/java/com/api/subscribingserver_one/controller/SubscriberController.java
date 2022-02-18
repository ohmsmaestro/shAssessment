package com.api.subscribingserver_one.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SubscriberController {
    @PostMapping(value = "/test1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> test1(@RequestBody Map<String, Object> payload){

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/test2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity test2(@RequestBody Map<String, Object> payload){

        return ResponseEntity.ok().build();
    }
}
