import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
public class CSVRottenTomatoes extends RottenTomatoes{

    public String filename;
    public String delimiter;
    public CSVRottenTomatoes(String filename, String delimiter){
        super();
        this.filename = filename;
        this.delimiter = delimiter;
    }

    @Override
    public List<FilmEntry> getFilmEntries() {
        List<FilmEntry> data = new LinkedList<FilmEntry>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                String title = values[2].trim();
                int score = Integer.parseInt(values[1].trim());
                int year = Integer.parseInt(values[0].trim());
                FilmEntry entry = new FilmEntry(title, score, year);
                data.add(entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
