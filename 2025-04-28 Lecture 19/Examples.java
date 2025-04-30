import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Examples {

    List<String> words = List.of("pineapple", "pear", "grapefruit");

    @Test
    public void guessLetterTestTypical() throws AlreadyGuessedException{
        WordGuesser wg = new WordGuesser(words,0,5);
        wg.guessLetter("p");
        wg.guessLetter("a");
        wg.guessLetter("z");

        // typing in more than one letter
        // typing in something that is not a letter: number or ""
        // typing in a letter that we've already guessed


        assertEquals("Current Game: p___app__\n" +
                        "Guessed Letters: [p, a, z]\n"+
                        "Guesses left: 4\n",
                wg.toString());
    }


    @Test
    public void guessLetterTestTypical2(){
        WordGuesser wg = new WordGuesser(words,0,5);
        try {
            wg.guessLetter("p");
            wg.guessLetter("a");
            wg.guessLetter("z");
        } catch (AlreadyGuessedException e) {
            fail("our code is bad");
        }
        // typing in more than one letter
        // typing in something that is not a letter: number or ""
        // typing in a letter that we've already guessed


        assertEquals("Current Game: p___app__\n" +
                        "Guessed Letters: [p, a, z]\n"+
                        "Guesses left: 4\n",
                wg.toString());
    }


    @Test(expected = AlreadyGuessedException.class)
    public void guessLetterTestTypical3() throws AlreadyGuessedException {
        WordGuesser wg = new WordGuesser(words,0,5);

        wg.guessLetter("p");
        wg.guessLetter("a");
        wg.guessLetter("a");
        // typing in more than one letter
        // typing in something that is not a letter: number or ""
        // typing in a letter that we've already guessed

    }


    @Test (expected = MoreThanOneLetterException.class)
    public void guessLetter() throws AlreadyGuessedException, MoreThanOneLetterException {
        WordGuesser wg = new WordGuesser(words,0,5);
        wg.guessLetter("p");
        wg.guessLetter("a");
        wg.guessLetter("pear");
        // typing in more than one letter
        // typing in something that is not a letter: number or ""
        // typing in a letter that we've already guessed


        assertEquals("Current Game: p___app__\n" +
                        "Guessed Letters: [p, a, z]\n"+
                        "Guesses left: 4\n",
                wg.toString());
    }


    @Test
    public void guessLetter2() throws AlreadyGuessedException, MoreThanOneLetterException {
        WordGuesser wg = new WordGuesser(words,0,5);
        try {
            wg.guessLetter("p");
            wg.guessLetter("a");
            wg.guessLetter("pear");
        } catch (MoreThanOneLetterException e) {
            wg.guessWord(e.getWord());
            fail("our code is bad");
        }
        // typing in more than one letter
        // typing in something that is not a letter: number or ""
        // typing in a letter that we've already guessed


        assertEquals("Current Game: p___app__\n" +
                        "Guessed Letters: [p, a, z]\n"+
                        "Guesses left: 4\n",
                wg.toString());
    }



}
