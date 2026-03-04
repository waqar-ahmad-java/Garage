package com.waqar.ship.shorturl;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShortUrlResponse {

    private String longUrl;
    private String shortUrl;
    private LocalDateTime expieryTime;
    private String error;

    @Override
    public String toString() {

        return "{" +
                "longUrl='" + longUrl + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                ", expieryTime=" + expieryTime +
                ", error='" + error + '\'' +
                '}';
    }
}
