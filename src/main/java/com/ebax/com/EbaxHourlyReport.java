package com.ebax.com;

import java.time.Instant;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author Bob
 * @since 2017/08/03
 */
public class EbaxHourlyReport {
    private final Instant targetHour;
    private Integer requestCount;
    private Integer impreCount;

    public EbaxHourlyReport(Instant targetHourstamp) {
        this.targetHour = targetHourstamp;
    }

    public EbaxHourlyReport(Instant targetHour,
                            int request,
                            int impression,
                            int cost) {
        this.targetHour = targetHour;
        this.requestCount = request;
        this.impreCount = impression;

    }

    public Instant getTargetHour() {
        return targetHour;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public void setImpreCount(Integer impreCount) {
        this.impreCount = impreCount;
    }

    public Integer getImpreCount() {
        return impreCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        EbaxHourlyReport that = (EbaxHourlyReport) o;

        return Objects.equals(this.impreCount, that.impreCount) && Objects.equals(this.requestCount, that.requestCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(impreCount, requestCount);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",
                                this.getClass()
                                    .getSimpleName() + "[",
                                "]").add("impreCount = " + impreCount)
                                    .add("requestCount = " + requestCount)
                                    .toString();
    }
}
