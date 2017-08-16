package com.ebax.com;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.Instant;

import static org.mockito.Mockito.*;

/**
 * @author Bob
 * @since 2017/08/03
 */

@RunWith(PowerMockRunner.class)
public class ReportServiceTest {
    @InjectMocks
    private ReportService service;
    @Mock
    private HourlyReportRepository hourlyReportRepository;
    @Mock
    private TenMaxAPI tenMaxAPI;

    @Test
    public void test_function_WHEN_situation1_THEN_data_saved() throws Exception {
        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    public void testUpdateReport_Ok() {
        // GIVEN
        Instant targetHour = mockNotFoundRecord("2017-03-25T00:00:00Z");

        // WHEN
        service.updateReport(targetHour);

        // THEN
        assertHourlyRecordIsSave(targetHour);
    }

    private void assertHourlyRecordIsSave(Instant targetHour) {
        EbaxHourlyReport expect = new EbaxHourlyReport(targetHour, 1000, 100, 300);
        Mockito.verify(hourlyReportRepository, times(1)).save(expect);
    }

    private Instant mockNotFoundRecord(String timeStampStr) {
        Instant targetHour = Instant.parse(timeStampStr);
        when(hourlyReportRepository.findByHourstamp(targetHour)).thenReturn(null);
        when(tenMaxAPI.fetchReport(targetHour)).thenReturn(goodTenMaxReportResponseXmlString());
        return targetHour;
    }

    @Test
    @Ignore
    public void testUpdateReport_fail_for_receive_incorrect_response() throws Exception {
        //GIVEN
        Instant targetHour = Instant.parse("2017-03-25T00:00:00Z");
        when(hourlyReportRepository.findByHourstamp(targetHour)).thenReturn(null);
        when(tenMaxAPI.fetchReport(targetHour)).thenReturn(badTenMaxResponseXmlString());

        //WHEN
        service.updateReport(targetHour);

        //THEN
        // Bob 發現 PowerMockito驚為天人的強大，馬上使用
        PowerMockito.verifyPrivate(service, never())
                    .invoke("updateRecordFromRemoteReport",
                            Matchers.any(),
                            Matchers.any());
    }

    @Test
    public void testUpdateReport_fail_for_receive_incorrect_response_v2() throws Exception {
        //GIVEN
        Instant targetHour = Instant.parse("2017-03-25T00:00:00Z");
        when(hourlyReportRepository.findByHourstamp(targetHour)).thenReturn(null);
        when(tenMaxAPI.fetchReport(targetHour)).thenReturn(badTenMaxResponseXmlString());

        //WHEN
        service.updateReport(targetHour);

        //THEN
        verify(hourlyReportRepository, never()).save(Mockito.any(EbaxHourlyReport.class));
    }


    private String badTenMaxResponseXmlString() {
        return "bad xml format";
    }

    private String goodTenMaxReportResponseXmlString() {
        return "<xml>Good response</xml>";
    }
}