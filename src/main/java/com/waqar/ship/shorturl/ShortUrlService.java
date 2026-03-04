package com.waqar.ship.shorturl;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    String getLongUrl(String shortUrl);
    void evictCache();
}
