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
    private AtomicInteger remaining;
    private Date reset;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public AtomicInteger getRemaining() {
        return remaining;
    }

    public void setRemaining(AtomicInteger remaining) {
        this.remaining = remaining;
    }

    public Date getReset() {
        return reset;
    }

    public void setReset(Date reset) {
        this.reset = reset;
    }
}
