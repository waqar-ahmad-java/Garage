package com.waqar.garage.consumer.controller;

import com.waqar.garage.consumer.dto.KafkaNotificationRequest;
import com.waqar.garage.consumer.service.kafka.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/{version}/kafka")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping()
    public ResponseEntity<String> getNotification(){
        String response = kafkaService.getNotification();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
