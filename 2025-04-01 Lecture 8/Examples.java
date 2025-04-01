import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Examples {

    /* Activity:
       Review at Cageable Interface from the video lecture
       Review Boa's implementation from the video lecture
       Review Zoo's implementation from the video lecture
       Do:
         Make the Zoo's test work for a list of Boa's by implementing the method.
         Add a new Cageable Dillo with:
         - an id number (dillo's have a tough life).
         - a length
         - a boolean saying whether it is rolled up into a ball
           a Dillo fits in a cage if its length is less than the cage length
           a Dillo is effectively half its own size if it is rolled up
           a Dillo's identifier is "dillo#%d" where %d is its id number
         Test Dillo
         Test Zoo's method with a mix of Boas and Dillos
         Make a third Animal that implements cageable
         Test Zoo's method with a mix of all three
     */



    @Test
    public void testBoaFitsIn5FtPen(){
        assertTrue(new Boa("Harvey",4,"Pizza", true).fitInExhibit(5));
    }

    @Test
    public void testBoaDoesNotFitIn5FtPen(){
        assertFalse(new Boa("Nokia",20,"Pixels", false).fitInExhibit(5));
    }

    @Test
    public void testZooOnListOfBoas(){
        Zoo aZoo = new Zoo(List.of(new Boa("Harvey",4,"Pizza", true),
                                   new Boa("Nokia",20,"Pixels", false)));
        assertEquals(List.of("Harvey"), aZoo.allThatFit(5));
    }

    @Test
    public void testDilloUnrolledTrue(){
        assertTrue(new Dillo(42,3,false).fitInExhibit(5));
    }

    @Test
    public void testDilloUnrolledFalse(){
        assertFalse(new Dillo(42,3,false).fitInExhibit(2));
    }

    @Test
    public void testDilloRolledTrue(){
        assertTrue(new Dillo(44,3,true).fitInExhibit(2));
    }

    @Test
    public void testDilloRolledFalse(){
        assertFalse(new Dillo(44,3,true).fitInExhibit(1));
    }

    @Test
    public void testZooWithBoasAndDillos(){
        Zoo aZoo = new Zoo(List.of(new Boa("Harvey",4,"Pizza", true),
                new Boa("Nokia",20,"Pixels", false),
                new Dillo(12,8,true),
                new Dillo(77,6,false)));
        assertEquals(List.of("Harvey", "dillo#12"), aZoo.allThatFit(5));
    }


}
