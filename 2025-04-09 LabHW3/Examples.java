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



}
