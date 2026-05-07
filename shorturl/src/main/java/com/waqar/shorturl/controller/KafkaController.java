package com.waqar.shorturl.controller;

import com.waqar.shorturl.dto.KafkaNotificationRequest;
import com.waqar.shorturl.service.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/{version}/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("add-notification")
    public ResponseEntity<String> addNotification(@RequestBody KafkaNotificationRequest kafkaNotificationRequest){
        String response = kafkaService.sendNotification(kafkaNotificationRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
