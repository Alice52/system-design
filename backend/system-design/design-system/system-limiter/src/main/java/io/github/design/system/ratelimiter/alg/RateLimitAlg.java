package io.github.design.system.ratelimiter.alg;

import com.google.common.base.Stopwatch;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author T04856 <br>
 * @create 2023-02-28 10:58 AM <br>
 * @project system-design <br>
 */
public class RateLimitAlg {
    // timeout for {@code Lock.tryLock()}
    private static final long TRY_LOCK_TIMEOUT = 200L; // 200ms
    private final int limit;
    private Stopwatch stopwatch;
    private AtomicInteger currentCount = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();

    public RateLimitAlg(int limit) {
        this(limit, Stopwatch.createStarted());
    }

    public RateLimitAlg(int limit, Stopwatch stopwatch) {
        this.limit = limit;
        this.stopwatch = stopwatch;
    }

    public boolean tryAcquire() throws InternalException {
        int updateCount = currentCount.incrementAndGet();
        if (updateCount <= limit) {
            return true;
        }

        try {
            if (lock.tryLock(TRY_LOCK_TIMEOUT, TimeUnit.MILLISECONDS)) {
                try {
                    if (stopwatch.elapsed(TimeUnit.MILLISECONDS)
                            > TimeUnit.SECONDS.toMillis(limit)) {
                        currentCount.set(0);
                        stopwatch.reset();
                    }
                    updateCount = currentCount.incrementAndGet();
                    return updateCount <= limit;
                } finally {
                    lock.unlock();
                }
            } else {
                throw new InternalException("tryAcquire() wait lock too long");
            }
        } catch (InterruptedException e) {
            throw new InternalException("tryAcquire() is interrupted by lock-time-out");
        }
    }
}
