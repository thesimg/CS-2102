import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordGuesser {

    private List<String> words;
    private char[] currentWord;

    private char[] currentGuess;

    private Set<Character> guessedLetters;

    private int maxGuesses;

    private int guessesUsed;
    public WordGuesser(List<String> words, int initial, int maxGuesses){
        this.words = words;
        this.maxGuesses = maxGuesses;
        start(initial);
    }

    public void start(int wordToGuess){
        this.currentWord = this.words.get(wordToGuess).toCharArray();
        this.currentGuess = new char[this.currentWord.length];
        for(int i = 0; i < this.currentGuess.length; i++){
            this.currentGuess[i] = '_';
        }
        this.guessedLetters = new HashSet<Character>();
        this.guessesUsed = 0;
    }

    public String toString(){
        return String.format("Current Game: %s\nGuessed Letters: %s",
                             String.copyValueOf(this.currentGuess), this.guessedLetters);

    }

    public void guessLetter(String letter) throws AlreadyGuessedException, MoreThanOneLetterException {
        if(letter.length() > 1){
            throw new MoreThanOneLetterException(letter);
        }
        if(guessedLetters.contains(letter.charAt(0))) {
            throw new AlreadyGuessedException(letter);
        }
        this.guessedLetters.add(letter.toCharArray()[0]);
        boolean foundLetter = false;
        for(int i = 0; i < currentWord.length; i++){
            if(String.valueOf(currentWord[i]).equals(letter)){
                foundLetter = true;
                currentGuess[i] = currentWord[i];
            }
        }
        if(! foundLetter) { guessesUsed++; }

    }

    public boolean guessWord(String word){
        if(currentWord.equals(word))
        {
            return true;
        }
        else {
            guessesUsed++;
            return false;
        }
    }

    public boolean hasGuessesLeft(){
        return this.guessesUsed < this.maxGuesses;
    }


}
