package com.waqar.ship.shorturl;

import com.waqar.ship.shorturl.repository.ShortUrlRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.waqar.ship.shorturl.entity.ShortUrl;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class ShortUrlServiceImpl implements ShortUrlService{

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @CachePut(value = "urlCache", key = "#result.getShortUrlHash()")
    @Override
    public ShortUrlResponse createShortUrl(ShortUrlRequest shortUrlRequest) {

        ShortUrlResponse response = new ShortUrlResponse();

     // Check if the long URL already exists
        Optional<ShortUrl> existing = shortUrlRepository.findByLongUrl(shortUrlRequest.getLongUrl());
        if (existing.isPresent()) {
//            existing.get();
            BeanUtils.copyProperties(existing.get(),response);

            return response;
        }

        // Generate a short URL (this is just an example, replace with your logic)
        String shortUrl = "http://localhost:8080/api/1/url/"+shortUrlRequest.getLongUrl().hashCode();

        // Save to the database
        ShortUrl newShortUrl = new ShortUrl();
        newShortUrl.setLongUrl(shortUrlRequest.getLongUrl());
        newShortUrl.setShortUrl(shortUrl);
        newShortUrl.setExpirationTime(LocalDateTime.now().plusHours(2));
        newShortUrl.setShortUrlHash(""+shortUrlRequest.getLongUrl().hashCode());
        ShortUrl shortUrlResponse =  shortUrlRepository.save(newShortUrl);
        BeanUtils.copyProperties(shortUrlResponse,response);

        return response;

    }

    @Cacheable(value = "urlCache", key = "#shortUrl")
    @Override
    public ShortUrlResponse getLongUrl(String shortUrl) throws InterruptedException {
        ShortUrlResponse response = new ShortUrlResponse();
        Thread.sleep(5000);
         Optional<ShortUrl> existing = shortUrlRepository.findByShortUrlHash(shortUrl);
         if (existing.isPresent()) {
             BeanUtils.copyProperties(existing.get(),response);
         }
         return response;
        
    }

    @Override
    @CacheEvict(cacheNames = {"urlCache"}, allEntries = true)
    public void evictCache() {
        System.out.println("Cache cleared");
    }
}
