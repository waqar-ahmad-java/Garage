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

    @Autowired
    ShortUrlService shortUrlService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createUrl(@RequestBody ShortUrlRequest longUrl){
        ShortUrlResponse response = shortUrlService.createShortUrl(longUrl);
        return new ResponseEntity<>(response.getShortUrl(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{shortUrl}")
    public ResponseEntity<String> getUrl(@PathVariable String shortUrl){
        ShortUrlResponse longUrl = shortUrlService.getLongUrl(shortUrl);

        if(longUrl.getError() != null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(longUrl.getError());
        }
        
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header("Location", longUrl.getLongUrl())
            .build();
    }
}
