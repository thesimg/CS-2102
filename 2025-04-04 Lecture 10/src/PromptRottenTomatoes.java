import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;
public class PromptRottenTomatoes extends RottenTomatoes{

    public int numberOfTimesToPrompt;
    public PromptRottenTomatoes(int numberOfTimesToPrompt){
        super();
        this.numberOfTimesToPrompt = numberOfTimesToPrompt;
    }
    @Override
    public List<FilmEntry> getFilmEntries() {
        List<FilmEntry> data = new LinkedList<FilmEntry>();
        for(int i = 0; i < numberOfTimesToPrompt; i++) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter a movie:");
            String title = keyboard.nextLine();
            System.out.println("Enter a score:");
            int score = Integer.parseInt(keyboard.nextLine());
            System.out.println("Enter a year:");
            int year = Integer.parseInt(keyboard.nextLine());
            data.add(new FilmEntry(title, score, year));
        }
        return data;
    }

}
