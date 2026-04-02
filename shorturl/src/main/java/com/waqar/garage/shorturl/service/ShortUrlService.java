package com.waqar.garage.shorturl.service;

import com.waqar.garage.shorturl.dto.ShortUrlRequest;
import com.waqar.garage.shorturl.dto.ShortUrlResponse;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String longUrl) throws InterruptedException;

    void evictCache();
}
