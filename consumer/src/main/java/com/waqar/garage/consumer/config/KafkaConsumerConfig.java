package com.waqar.garage.consumer.config;

import com.waqar.garage.consumer.dto.KafkaNotificationRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    private String kafkaServer = "localhost:9092";
    private String groupId = "shorturl-group";

    @Bean
    public ConsumerFactory<String, KafkaNotificationRequest> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JacksonJsonDeserializer.class);
        config.put(JacksonJsonDeserializer.VALUE_DEFAULT_TYPE, "com.waqar.garage.consumer.dto.KafkaNotificationRequest");
        config.put(JacksonJsonDeserializer.USE_TYPE_INFO_HEADERS,"false");
        config.put(JacksonJsonDeserializer.TRUSTED_PACKAGES,"*");

        return new DefaultKafkaConsumerFactory<>(config);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaNotificationRequest> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaNotificationRequest> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}