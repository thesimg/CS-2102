public class Media {
    protected String title;
    protected String author;

    public Media(String title, String author){
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString(){
        return String.format("\"%s\" by %s", this.title, this.author);
    }

    public boolean isCreatedBy(String author){
        return this.author.equals(author);
    }

}
