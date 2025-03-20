import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    @Test
    public void testDoublingNumbers(){
        assertEquals(4, 2*2);
    }

    @Test
    public void testTriple(){
        Multiplier multi = new Multiplier();
        assertEquals(3, multi.triple(1), 0.01);
    }

    @Test
    public void testCandies(){
        Multiplier multi = new Multiplier();
        assertEquals(10, multi.costForCandy(20), 0.01);
    }

    @Test
    public void testQuizPercentage(){
        GradeCalculator gradeCalc = new GradeCalculator();
        assertEquals(0.8, gradeCalc.quizPercentage(30,50,40,40),0.01);
    }

    @Test
    public void testQuizPercentage2(){
        GradeCalculator gradeCalc = new GradeCalculator();
        assertEquals(1, gradeCalc.quizPercentage(50,50,50,50),0.01);
    }

    @Test
    public void testFuzzyLetter(){
        GradeCalculator gradeCalc = new GradeCalculator();
        assertEquals("My grade is: B", gradeCalc.fuzzyLetterGrade(50,50,50,50,230,5));
    }

    @Test
    public void testHWPercentage(){
        GradeCalculator gradeCalc = new GradeCalculator();
        assertEquals(1.0, gradeCalc.hwPercentage(120,2), 0.01);
    }
}
