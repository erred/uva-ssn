package com.google.api.client.testing.util;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

@Beta
public class MockBackOff implements BackOff {
    private long backOffMillis;
    private int maxTries = 10;
    private int numTries;

    public void reset() throws IOException {
        this.numTries = 0;
    }

    public long nextBackOffMillis() throws IOException {
        if (this.numTries >= this.maxTries || this.backOffMillis == -1) {
            return -1;
        }
        this.numTries++;
        return this.backOffMillis;
    }

    public MockBackOff setBackOffMillis(long j) {
        Preconditions.checkArgument(j == -1 || j >= 0);
        this.backOffMillis = j;
        return this;
    }

    public MockBackOff setMaxTries(int i) {
        Preconditions.checkArgument(i >= 0);
        this.maxTries = i;
        return this;
    }

    public final int getMaxTries() {
        return this.numTries;
    }

    public final int getNumberOfTries() {
        return this.numTries;
    }
}
