package com.waqar.shorturl.service;

import com.waqar.shorturl.dto.ShortUrlResponse;
import com.waqar.shorturl.entity.ShortUrl;
import com.waqar.shorturl.repository.ShortUrlRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShortUrlServiceImplTest {

    @Mock
    private ShortUrlRepository shortUrlRepository;

    @InjectMocks
    private ShortUrlServiceImpl shortUrlService;

    @Test
    void getAllShortUrls_shouldMapEntitiesToResponses() {
        ShortUrl entity = new ShortUrl();
        entity.setLongUrl("https://example.com");
        entity.setShortUrl("http://localhost:8080/api/1/url/123");
        entity.setShortUrlHash("123");
        entity.setExpirationTime(LocalDateTime.now().plusHours(1));

        when(shortUrlRepository.findAll()).thenReturn(List.of(entity));

        Set<ShortUrlResponse> responses = shortUrlService.getAllShortUrls();

        assertThat(responses).hasSize(1);
        ShortUrlResponse response = responses.iterator().next();
        assertThat(response.getLongUrl()).isEqualTo("https://example.com");
        assertThat(response.getShortUrl()).isEqualTo("http://localhost:8080/api/1/url/123");
        assertThat(response.getShortUrlHash()).isEqualTo("123");
    }
}
