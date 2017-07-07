package org.github.codestar.crawler.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vlevash on 26.06.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {
    private int limit;
    private int remaining;
    private long reset;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public long getReset() {
        return reset;
    }

    public void setReset(long reset) {
        this.reset = reset;
    }
}
