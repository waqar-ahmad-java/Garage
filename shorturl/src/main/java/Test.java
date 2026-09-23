import com.waqar.utils.base62.Base62;

import java.util.concurrent.atomic.AtomicLong;

public class Test {
    static void main() {
        final AtomicLong counter = new AtomicLong();
        counter.set(1000000000000L);

        String base64Result = Base62.getEncoder().encode(counter.get());

        IO.println(base64Result);
        IO.println(Base62.getEncoder().encode(1000000000000L));
    }
}
