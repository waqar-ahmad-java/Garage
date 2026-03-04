package com.waqar.ship.shorturl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.waqar.ship.shorturl.entity.ShortUrl;


@RequestMapping("api/{version}/url")
@RestController
public class ShortUrlController {

    private final ShortUrlService shortUrlService;

    ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUrl(@RequestBody ShortUrlRequest longUrl){
        ShortUrlResponse response = shortUrlService.createShortUrl(longUrl);
        return new ResponseEntity<>(response.getShortUrl(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{shortUrl}")
    public ResponseEntity<String> getUrl(@PathVariable String shortUrl){
        String longUrl = shortUrlService.getLongUrl(shortUrl);

        if("".equalsIgnoreCase(longUrl)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header("Location", longUrl)
            .build();
    }
    @GetMapping(value = "/cache/evict")
    public ResponseEntity<Object> getUrl(){
        shortUrlService.evictCache();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
    }
}
