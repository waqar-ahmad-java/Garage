package com.waqar.shorturl.config;


import com.waqar.utils.base62.Base62;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;


public class Counter {

    private final AtomicLong counter = new AtomicLong();

    public long getCount() {
        return counter.get();
    }
    public long increment(){
        return counter.incrementAndGet();
    }

    public String getBase64(){
        byte[] bytes = ByteBuffer.allocate(Long.BYTES).putLong(this.getCount()).array();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public String getBase62() {
        return Base62.getEncoder().encode(this.getCount());
    }
}
