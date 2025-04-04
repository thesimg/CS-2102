import java.util.List;
public class MockRottenTomatoes extends RottenTomatoes{

    public List<FilmEntry> mockEntries;
    public MockRottenTomatoes(List<FilmEntry> mockEntries){
        super();
        this.mockEntries = mockEntries;
    }

    @Override
    public List<FilmEntry> getFilmEntries() {
        return mockEntries;
    }
}
