import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Examples {

    public ProcessStrings ps = new ProcessStrings(List.of("hello", "every", "CS", "2102", "student"));

    @Test
    public void testTotalCharacters(){
        assertEquals(23, ps.totalCharacters());

        List<String> foods = new LinkedList<>();
        foods.add("candy");
        foods.add("milk");
        foods.add("chicken");
        ProcessStrings ps2 = new ProcessStrings(foods);

        assertEquals(16, ps2.totalCharacters());
    }

    @Test
    public void testLongestString(){
        assertEquals("student", ps.longestString());
        assertEquals("", new ProcessStrings(List.of()).longestString());
    }

    @Test
    public void testStringWithLength(){
        assertEquals(List.of("hello", "every") ,ps.stringsWithLength(5)); //wordle words?
    }

}
