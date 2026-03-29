package com.waqar.garage.shorturl;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String longUrl) throws InterruptedException;

    void evictCache();
}
