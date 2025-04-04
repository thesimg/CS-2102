import java.util.List;

public class Song extends Media{
    public String lyrics;

    public Song(String title, String author, String lyrics){
        super(title, author);
        this.lyrics = lyrics;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Song b){
            return this.title.equals(b.title) && this.author.equals(b.author);
        }
        return false;
    }

    public int howManyLyrics(){
        String[] lyricLines = this.lyrics.split("\n");
        return lyricLines.length;
    }
}
