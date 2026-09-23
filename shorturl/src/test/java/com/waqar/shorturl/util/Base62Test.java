package com.waqar.shorturl.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Base62Test {

    @Test
    void shouldEncodeAndDecodeStringRoundTrip() {
        String original = "https://example.com/very/long/path?key=123";

        String encoded = Base62.getEncoder().encodeToString(original);

        assertThat(encoded).isNotBlank();
        assertThat(Base62.getDecoder().decodeToString(encoded)).isEqualTo(original);
    }

    @Test
    void shouldEncodeAndDecodeLongValues() {
        assertThat(Base62.getEncoder().encode(0)).isEqualTo("A");
        assertThat(Base62.getEncoder().encode(1)).isEqualTo("B");
        assertThat(Base62.getEncoder().encode(125)).isEqualTo("CB");
        assertThat(Base62.getDecoder().decodeLong("CB")).isEqualTo(125L);
    }
}
