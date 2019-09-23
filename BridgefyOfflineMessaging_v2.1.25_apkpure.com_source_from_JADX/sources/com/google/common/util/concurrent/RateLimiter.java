package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class RateLimiter {
    double maxPermits;
    private final Object mutex;
    private long nextFreeTicketMicros;
    private final long offsetNanos;
    volatile double stableIntervalMicros;
    double storedPermits;
    private final SleepingTicker ticker;

    private static class Bursty extends RateLimiter {
        final double maxBurstSeconds;

        /* access modifiers changed from: 0000 */
        public long storedPermitsToWaitTime(double d, double d2) {
            return 0;
        }

        Bursty(SleepingTicker sleepingTicker, double d) {
            super(sleepingTicker);
            this.maxBurstSeconds = d;
        }

        /* access modifiers changed from: 0000 */
        public void doSetRate(double d, double d2) {
            double d3 = this.maxPermits;
            this.maxPermits = this.maxBurstSeconds * d;
            double d4 = 0.0d;
            if (d3 != 0.0d) {
                d4 = (this.storedPermits * this.maxPermits) / d3;
            }
            this.storedPermits = d4;
        }
    }

    @VisibleForTesting
    static abstract class SleepingTicker extends Ticker {
        static final SleepingTicker SYSTEM_TICKER = new SleepingTicker() {
            public long read() {
                return systemTicker().read();
            }

            public void sleepMicrosUninterruptibly(long j) {
                if (j > 0) {
                    Uninterruptibles.sleepUninterruptibly(j, TimeUnit.MICROSECONDS);
                }
            }
        };

        /* access modifiers changed from: 0000 */
        public abstract void sleepMicrosUninterruptibly(long j);

        SleepingTicker() {
        }
    }

    private static class WarmingUp extends RateLimiter {
        private double halfPermits;
        private double slope;
        final long warmupPeriodMicros;

        WarmingUp(SleepingTicker sleepingTicker, long j, TimeUnit timeUnit) {
            super(sleepingTicker);
            this.warmupPeriodMicros = timeUnit.toMicros(j);
        }

        /* access modifiers changed from: 0000 */
        public void doSetRate(double d, double d2) {
            double d3 = this.maxPermits;
            this.maxPermits = ((double) this.warmupPeriodMicros) / d2;
            this.halfPermits = this.maxPermits / 2.0d;
            this.slope = ((3.0d * d2) - d2) / this.halfPermits;
            if (d3 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
            } else {
                this.storedPermits = d3 == 0.0d ? this.maxPermits : (this.storedPermits * this.maxPermits) / d3;
            }
        }

        /* access modifiers changed from: 0000 */
        public long storedPermitsToWaitTime(double d, double d2) {
            long j;
            double d3 = d - this.halfPermits;
            if (d3 > 0.0d) {
                double min = Math.min(d3, d2);
                j = (long) (((permitsToTime(d3) + permitsToTime(d3 - min)) * min) / 2.0d);
                d2 -= min;
            } else {
                j = 0;
            }
            return (long) (((double) j) + (this.stableIntervalMicros * d2));
        }

        private double permitsToTime(double d) {
            return this.stableIntervalMicros + (d * this.slope);
        }
    }

    /* access modifiers changed from: 0000 */
    public abstract void doSetRate(double d, double d2);

    /* access modifiers changed from: 0000 */
    public abstract long storedPermitsToWaitTime(double d, double d2);

    public static RateLimiter create(double d) {
        return create(SleepingTicker.SYSTEM_TICKER, d);
    }

    @VisibleForTesting
    static RateLimiter create(SleepingTicker sleepingTicker, double d) {
        Bursty bursty = new Bursty(sleepingTicker, 1.0d);
        bursty.setRate(d);
        return bursty;
    }

    public static RateLimiter create(double d, long j, TimeUnit timeUnit) {
        return create(SleepingTicker.SYSTEM_TICKER, d, j, timeUnit);
    }

    @VisibleForTesting
    static RateLimiter create(SleepingTicker sleepingTicker, double d, long j, TimeUnit timeUnit) {
        WarmingUp warmingUp = new WarmingUp(sleepingTicker, j, timeUnit);
        warmingUp.setRate(d);
        return warmingUp;
    }

    @VisibleForTesting
    static RateLimiter createWithCapacity(SleepingTicker sleepingTicker, double d, long j, TimeUnit timeUnit) {
        Bursty bursty = new Bursty(sleepingTicker, ((double) timeUnit.toNanos(j)) / 1.0E9d);
        bursty.setRate(d);
        return bursty;
    }

    private RateLimiter(SleepingTicker sleepingTicker) {
        this.mutex = new Object();
        this.nextFreeTicketMicros = 0;
        this.ticker = sleepingTicker;
        this.offsetNanos = sleepingTicker.read();
    }

    public final void setRate(double d) {
        Preconditions.checkArgument(d > 0.0d && !Double.isNaN(d), "rate must be positive");
        synchronized (this.mutex) {
            resync(readSafeMicros());
            double micros = ((double) TimeUnit.SECONDS.toMicros(1)) / d;
            this.stableIntervalMicros = micros;
            doSetRate(d, micros);
        }
    }

    public final double getRate() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.stableIntervalMicros;
    }

    public double acquire() {
        return acquire(1);
    }

    public double acquire(int i) {
        long reserve = reserve(i);
        this.ticker.sleepMicrosUninterruptibly(reserve);
        return (((double) reserve) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    /* access modifiers changed from: 0000 */
    public long reserve() {
        return reserve(1);
    }

    /* access modifiers changed from: 0000 */
    public long reserve(int i) {
        long reserveNextTicket;
        checkPermits(i);
        synchronized (this.mutex) {
            reserveNextTicket = reserveNextTicket((double) i, readSafeMicros());
        }
        return reserveNextTicket;
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) {
        return tryAcquire(1, j, timeUnit);
    }

    public boolean tryAcquire(int i) {
        return tryAcquire(i, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire(int i, long j, TimeUnit timeUnit) {
        long micros = timeUnit.toMicros(j);
        checkPermits(i);
        synchronized (this.mutex) {
            long readSafeMicros = readSafeMicros();
            if (this.nextFreeTicketMicros > micros + readSafeMicros) {
                return false;
            }
            long reserveNextTicket = reserveNextTicket((double) i, readSafeMicros);
            this.ticker.sleepMicrosUninterruptibly(reserveNextTicket);
            return true;
        }
    }

    private static void checkPermits(int i) {
        Preconditions.checkArgument(i > 0, "Requested permits must be positive");
    }

    private long reserveNextTicket(double d, long j) {
        resync(j);
        long max = Math.max(0, this.nextFreeTicketMicros - j);
        double min = Math.min(d, this.storedPermits);
        this.nextFreeTicketMicros += storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d - min) * this.stableIntervalMicros));
        this.storedPermits -= min;
        return max;
    }

    private void resync(long j) {
        if (j > this.nextFreeTicketMicros) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (((double) (j - this.nextFreeTicketMicros)) / this.stableIntervalMicros));
            this.nextFreeTicketMicros = j;
        }
    }

    private long readSafeMicros() {
        return TimeUnit.NANOSECONDS.toMicros(this.ticker.read() - this.offsetNanos);
    }

    public String toString() {
        return String.format("RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(1000000.0d / this.stableIntervalMicros)});
    }
}
