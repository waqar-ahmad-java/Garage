package com.waqar.shorturl.dto;

public record KafkaNotificationRequest(String type, String message) {
}
