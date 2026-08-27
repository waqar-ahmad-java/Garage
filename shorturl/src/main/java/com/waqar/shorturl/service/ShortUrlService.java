package com.waqar.shorturl.service;

import com.waqar.shorturl.dto.ShortUrlRequest;
import com.waqar.shorturl.dto.ShortUrlResponse;

import java.util.Set;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String longUrl) throws InterruptedException;
    Set<ShortUrlResponse> getAllShortUrls();

    void evictCache();
}
