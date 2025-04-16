import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Examples {
    @Test
    public void testBPtempsOutsideRange(){
        THSensible th = new THBP();
        th.collect("20250409 T 68.0 H 30.0");
        th.collect("20250407 T 10.0 H 10.0");
        assertEquals(1, th.tempsOutsideRange(50, 80));
    }

    @Test
    public void testBPavgHumidity(){
        THSensible th = new THBP();
        th.collect("20250409 T 68.0 H 30.0");
        th.collect("20250407 T 10.0 H 10.0");
        assertEquals(20.0, th.avgHumidity(), 0.02);
    }

    @Test
    public void testBPavgHumidityNoData(){
        THSensible th = new THBP();
        assertEquals(0, th.avgHumidity(), 0.02);
    }

    @Test
    public void testBPmaxHumidity(){
        THSensible th = new THBP();
        th.collect("20250409 T 68.0 H 30.0");
        th.collect("20250407 T 10.0 H 10.0");
        assertEquals(30.0, th.maxHumidity(), 0.02);
    }

    @Test
    public void testBPmaxHumidityNoData(){
        THSensible th = new THBP();
        assertEquals(0, th.maxHumidity(), 0.02);
    }

    @Test
    public void testBPminHumidity(){
        THSensible th = new THBP();
        th.collect("20250409 T 68.0 H 30.0");
        th.collect("20250407 T 10.0 H 10.0");
        assertEquals(10.0, th.minHumidity(), 0.02);
    }

    @Test
    public void testBPminHumidityNoData(){
        THSensible th = new THBP();
        assertEquals(0, th.minHumidity(), 0.02);
    }

    @Test
    public void testCollectTiming(){
        THSensible bp = new THBP();
        THSensible rtp = new THRTP();
        long preBP = System.nanoTime();
        bp.collect("20250409 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0 T 68.0 H 30.0");
        long postBP = System.nanoTime();
        long deltaBP = postBP - preBP;
        long preRTP = System.nanoTime();
        rtp.collect("20250407 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0 T 10.0 H 10.0");
        long postRTP = System.nanoTime();
        long deltaRTP = postRTP - preRTP;
        assertTrue(deltaBP < deltaRTP);
    }

    @Test
    public void testAuditorCountsErrors() {
        THBPAuditor auditor = new THBPAuditor();
        auditor.collect("20250409 T 68.0 H 30.0 Err T 70.0");
        auditor.collect("20250410 T 72.0 Err H 40.0");
        assertEquals(2, auditor.getErrorCount());
    }

    @Test
    public void testAuditorStillComputesHumidity() {
        THBPAuditor auditor = new THBPAuditor();
        auditor.collect("20250409 T 68.0 H 30.0 Err T 70.0");
        auditor.collect("20250410 T 72.0 Err H 40.0");
        assertEquals(35.0, auditor.avgHumidity(), 0.01);
    }

    @Test
    public void testRTPDateOnlyKeepsMatchingDate() {
        THSensible sensor = new THRTPDate("20250409");
        sensor.collect("20250409 T 68.0 H 30.0 T 70.0");
        sensor.collect("20250410 T 99.0 H 99.0");
        assertEquals(0, sensor.tempsOutsideRange(60, 80)); // within range
        assertEquals(30.0, sensor.minHumidity(), 0.01);
    }

    @Test
    public void testRTPDateIgnoresOtherDates() {
        THSensible sensor = new THRTPDate("20250410");
        sensor.collect("20250409 T 20.0 H 10.0"); // should be ignored
        sensor.collect("20250410 T 100.0 H 90.0");
        assertEquals(1, sensor.tempsOutsideRange(50, 80));
        assertEquals(90.0, sensor.avgHumidity(), 0.01);
    }


}
