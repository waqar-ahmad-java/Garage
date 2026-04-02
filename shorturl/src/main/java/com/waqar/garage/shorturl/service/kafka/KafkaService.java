package com.waqar.garage.shorturl.service.kafka;

import com.waqar.garage.shorturl.dto.KafkaNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, KafkaNotificationRequest> kakfaTemplate;

    public String sendNotification(KafkaNotificationRequest kafkaNotificationRequest){
        kakfaTemplate.send("shorturl-notification",kafkaNotificationRequest);
        return "Email Notificaiton sent";
    }

}
