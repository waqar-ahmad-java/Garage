package com.waqar.shorturl.service;

import com.waqar.shorturl.dto.ShortUrlRequest;
import com.waqar.shorturl.dto.ShortUrlResponse;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String longUrl) throws InterruptedException;

    void evictCache();
}
