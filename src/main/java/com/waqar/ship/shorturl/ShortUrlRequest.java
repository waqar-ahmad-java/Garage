package com.waqar.ship.shorturl;


import lombok.Data;

import java.util.Objects;

@Data
public class ShortUrlRequest {
    private String longUrl;
    private String shortUrl;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShortUrlRequest that = (ShortUrlRequest) o;
        return Objects.equals(longUrl, that.longUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(longUrl);
    }
}
