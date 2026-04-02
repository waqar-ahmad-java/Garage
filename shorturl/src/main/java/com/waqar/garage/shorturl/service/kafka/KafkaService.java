package com.waqar.garage.shorturl.service.kafka;

import com.waqar.garage.shorturl.dto.KafkaNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String, KafkaNotificationRequest> kakfaTemplate;


}
