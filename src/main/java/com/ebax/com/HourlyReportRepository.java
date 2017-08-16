package com.ebax.com;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

/**
 * @author Bob
 * @since 2017/08/03
 */
public interface HourlyReportRepository extends JpaRepository<EbaxHourlyReport, String> {
    EbaxHourlyReport findByHourstamp(Instant targetHourstamp);
}
