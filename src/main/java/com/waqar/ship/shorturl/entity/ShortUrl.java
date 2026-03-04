package com.waqar.ship.shorturl.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String longUrl;
    private String shortUrl;
    private String shortUrlHash;
    @CreationTimestamp
    private LocalDateTime creationDate;

    private LocalDateTime expirationTime;
}