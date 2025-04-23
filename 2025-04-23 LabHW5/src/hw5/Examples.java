package hw5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {

    @Test
    public void typicalGreenhouse(){
        GHCalendar cal = new GHCalendar("20250421");
        GreenHouse gh = new GreenHouse(cal);
        gh.pollSensors();
        gh.pollSensors();
        gh.pollSensors();
        gh.advance();
        gh.pollSensors();
        gh.pollSensors();
        gh.toggleLamp();
        gh.toggleSprinkler();
        gh.pollSensors();
        gh.advance();
        assertEquals("20250423", gh.currentYYYYMMDD());
        assertEquals("{20250421 | abnormal temps: 7 | humidity: 3.6 33.6 72.3}", gh.generateReport());
        gh.adjustHiTemp(68.0);
        gh.adjustLowTemp(62.1);
        assertEquals("{20250421 | abnormal temps: 9 | humidity: 3.6 33.6 72.3}", gh.generateReport());
        assertEquals("{20250422 | abnormal temps: 8 | humidity: 2.8 55.2 97.3}", gh.generateReport("20250422"));
        assertEquals("{20250422 | abnormal temps: 8 | humidity: 2.8 55.2 97.3}", gh.generateReport());
        assertEquals("{20250421 - 20250422 | abnormal temps: 17 | humidity: 3.2 44.4 84.8}", gh.generateReport("20250421", "20250422"));
        assertEquals("{20250422 | abnormal temps: 8 | humidity: 2.8 55.2 97.3}", gh.generateReport());
        gh.undo();
        gh.undo();
        assertEquals("20250421",gh.currentYYYYMMDD());
        assertEquals("{20250422 | abnormal temps: 0 | humidity: 0.0 0.0 0.0}",gh.generateReport("20250422"));
        assertEquals("{20250421 | abnormal temps: 9 | humidity: 3.6 33.6 72.3}", gh.generateReport("20250421"));
        gh.pollSensors();
        assertEquals("{20250421 | abnormal temps: 12 | humidity: 3.6 40.4 98.4}",gh.generateReport("20250421"));
    }

}
