public class AlreadyGuessedException extends Exception {
    public AlreadyGuessedException(String letter) {
        super("We already guessed the letter: " + letter);

    }
}
