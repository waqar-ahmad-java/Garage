package com.waqar.garage.consumer.service.kafka;

import com.waqar.garage.consumer.dto.KafkaNotificationRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private String notification;

    @KafkaListener(topics="shorturl-notification", groupId = "shorturl-group")
    public void getNotification(KafkaNotificationRequest kafkaNotificationRequest){
        notification = kafkaNotificationRequest+" Got notification";
        System.out.println(notification);
    }

    public String getNotification(){
        return notification;
    }


}
