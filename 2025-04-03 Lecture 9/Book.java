import java.util.List;

public class Book {
    public String title;
    public String author;
    public List<String> chapters;

    public Book(String title, String author, List<String> chapters){
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    @Override
    public String toString(){
        return String.format("\"%s\" by %s", this.title, this.author);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Book b){
            return this.title.equals(b.title) && this.author.equals(b.author);
        }
        return false;
    }

    public boolean isCreatedBy(String author){
        return this.author.equals(author);
    }

    public int numberOfChapters(){
        return this.chapters.size();
    }
}
