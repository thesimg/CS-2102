import java.util.List;

public class Song {
    public String title;
    public String author;
    public String lyrics;

    public Song(String title, String author, String lyrics){
        this.title = title;
        this.author = author;
        this.lyrics = lyrics;
    }

    @Override
    public String toString(){
        return String.format("\"%s\" by %s", this.title, this.author);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Song b){
            return this.title.equals(b.title) && this.author.equals(b.author);
        }
        return false;
    }

    public boolean isCreatedBy(String author){
        return this.author.equals(author);
    }

    public int howManyLyrics(){
        String[] lyricLines = this.lyrics.split("\n");
        return lyricLines.length;
    }
}
