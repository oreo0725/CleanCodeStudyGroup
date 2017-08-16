package com.ebax.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.text.ParseException;
import java.time.Instant;
import java.util.Optional;

/**
 * @author Bob
 * @since 2017/08/03
 */
public class ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    private final HourlyReportRepository hourlyReportRepository;
    private final TenMaxAPI tenMaxAPI;

    @Inject
    public ReportService(HourlyReportRepository hourlyReportRepository,
                         TenMaxAPI tenMaxAPI) {
        this.hourlyReportRepository = hourlyReportRepository;
        this.tenMaxAPI = tenMaxAPI;
    }

    public void updateReport(Instant targetHourstamp) {

        EbaxHourlyReport ebaxHourlyReport = Optional.ofNullable(hourlyReportRepository.findByHourstamp(targetHourstamp))
                                                    .orElse(new EbaxHourlyReport(targetHourstamp));

        try {
            String reportBody = tenMaxAPI.fetchReport(targetHourstamp);
            TenMaxHourlyReport tenMaxHourlyReport = parseTenMaxReport(reportBody);
            updateRecordFromRemoteReport(tenMaxHourlyReport, ebaxHourlyReport);
            hourlyReportRepository.save(ebaxHourlyReport);
        }
        catch(ParseException e) {
            logger.error("update fail from TenMaxReport for hourstamp:{}", targetHourstamp, e);
        }
    }

    private TenMaxHourlyReport parseTenMaxReport(String reportXml) throws ParseException {
        if(reportXml.contains("bad xml format")) {
            throw new ParseException("unsupport xml format", 0);
        }

        TenMaxHourlyReport report = new TenMaxHourlyReport();
        report.setImpression(100);
        report.setRequestCount(1000);
        return report;
    }

    private void updateRecordFromRemoteReport(TenMaxHourlyReport src, EbaxHourlyReport target) {
        target.setRequestCount(src.getRequestCount());
        target.setImpreCount(src.getImpression());
        // series properties to assign ...
    }
}
