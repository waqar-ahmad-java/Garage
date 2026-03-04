package com.waqar.ship.shorturl;

public interface ShortUrlService {
    ShortUrlResponse createShortUrl(ShortUrlRequest longUrl);
    ShortUrlResponse getLongUrl(String shortUrl);
}
