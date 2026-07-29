package com.waqar.shorturl.controller;

import com.waqar.shorturl.dto.ShortUrlRequest;
import com.waqar.shorturl.dto.ShortUrlResponse;
import com.waqar.shorturl.service.ShortUrlService;
import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("api/{version}/url")
@RestController
public class ShortUrlController {
    private static final Logger log = LoggerFactory.getLogger(ShortUrlController.class);

    private final ShortUrlService shortUrlService;

    ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getAllUrl() {
        log.info("Controller all urls");
        return new ResponseEntity<>(shortUrlService.getAllShortUrls(), HttpStatus.OK);

    }
    @PostMapping(value = "/create")
    public ResponseEntity<String> createUrl(@RequestBody ShortUrlRequest longUrl){
        ShortUrlResponse response = shortUrlService.createShortUrl(longUrl);
        return new ResponseEntity<>(response.getShortUrl(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{shortUrl}")
    @Observed(name ="getUrl.count")
    public ResponseEntity<String> getUrl(@RequestParam String shortUrl) throws InterruptedException {
        log.info("Controller getUrl started");
        ShortUrlResponse longUrl = shortUrlService.getLongUrl(shortUrl);

        if("".equalsIgnoreCase(longUrl.getLongUrl())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }

        log.info("Controller getUrl ended");
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY)
            .header("Location", longUrl.getLongUrl())
            .build();
    }
    @GetMapping(value = "/cache/evict")
    public ResponseEntity<Object> getUrl(){
        shortUrlService.evictCache();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("");
    }
}
