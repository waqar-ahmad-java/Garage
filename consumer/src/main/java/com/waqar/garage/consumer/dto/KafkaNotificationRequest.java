package com.waqar.garage.consumer.dto;

public record KafkaNotificationRequest(String type, String message) {
}
