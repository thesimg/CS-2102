import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Examples {

    List<String> words = List.of("pineapple", "pear", "grapefruit");
    @Test
    public void guessLetterTestTypical(){
        WordGuesser wg = new WordGuesser(words,0,5);
        wg.guessLetter("p");
        wg.guessLetter("a");
        wg.guessLetter("z");
        assertEquals("Current Game: p___app__\n" +
                        "Guessed Letters: [p, a, z]\n"+
                        "Guesses left: 4\n",
                wg.toString());
    }




}
