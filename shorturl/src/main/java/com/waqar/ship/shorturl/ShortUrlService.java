package com.waqar.ship.shorturl;

import org.springframework.cache.annotation.Cacheable;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String longUrl) throws InterruptedException;

    void evictCache();
}
