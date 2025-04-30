/** The number of first, second, and third votes a single person has */
public class Votes { // immutably-designed data structure
    private int firstVotes;
    private int secondVotes;
    private int thirdVotes;
    /** normal constructor */
    public Votes(int first, int second, int third){
        this.firstVotes = first;
        this.secondVotes = second;
        this.thirdVotes = third;
    }
    /** copy constructor */
    public Votes(Votes v){
        this.firstVotes = v.firstVotes;
        this.secondVotes = v.secondVotes;
        this.thirdVotes = v.thirdVotes;
    }
    public int getFirstVotes(){
        return this.firstVotes;
    }
    public int getSecondVotes(){
        return this.secondVotes;
    }
    public int getThirdVotes(){
        return this.thirdVotes;
    }
}