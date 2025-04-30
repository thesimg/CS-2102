public class MoreThanOneLetterException extends Exception {
    String word;

    public MoreThanOneLetterException(String word) {
        super("Guessed a word instead of a letter: " + word);
        this.word = word;
    }

    public String getWord(){
        return this.word;
    }
}
