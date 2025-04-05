import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRottenTomatoes extends RottenTomatoes {

    List<FilmEntry> randomExtries;
    public RandomRottenTomatoes(List<FilmEntry> randomExtries){
        this.randomExtries = randomExtries;
    }

    @Override
    public List<FilmEntry> getFilmEntries() {
        Random r = new Random();
        List<FilmEntry> filmEntries = new ArrayList<>();
        int num = r.nextInt(26);
        for (int i = 0; i < num; i++) {
            FilmEntry filmEntry = new FilmEntry("Breaking Bad Episode" + i,
                    r.nextInt(10) + 1, r.nextInt(10) + 1);
            filmEntries.add(filmEntry);
        }
        return filmEntries;
    }
}
