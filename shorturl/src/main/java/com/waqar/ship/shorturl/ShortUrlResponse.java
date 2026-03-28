package com.waqar.ship.shorturl;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ShortUrlResponse implements Serializable {

    private String longUrl;
    private String shortUrl;
    private String shortUrlHash;
    private LocalDateTime expieryTime;
    private String error;

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getShortUrlHash() {
        return shortUrlHash;
    }

    public void setShortUrlHash(String shortUrlHash) {
        this.shortUrlHash = shortUrlHash;
    }

    public LocalDateTime getExpieryTime() {
        return expieryTime;
    }

    public void setExpieryTime(LocalDateTime expieryTime) {
        this.expieryTime = expieryTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

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
